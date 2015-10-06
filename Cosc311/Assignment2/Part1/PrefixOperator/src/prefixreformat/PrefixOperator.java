package prefixreformat;
import java.util.Stack;
import java.util.StringTokenizer;

public class PrefixOperator 
{
   public void Operate(String input)
   {
        Stack<Object> stack = new Stack<Object>();
        StringTokenizer st = new StringTokenizer(input);
        Object temp;
        while (st.hasMoreTokens()) 
        {
            temp = st.nextElement();
            String tmpstr = temp.toString();
            if(Character.isDigit(tmpstr.charAt(0)))
            {
                int foo = Integer.parseInt(tmpstr);
                stack.push(foo);
                System.out.println("Pushed Int: " + foo);
            }
            else
            {
                int num1 = (int)stack.pop();
                int num2 = (int)stack.pop();
                int num3;
                char ch = tmpstr.charAt(0);
                if(ch == '+')
                {
                    num3 = num1+num2;
                    stack.push(num3);
                    System.out.println("+ Operator");         
                }
                else if(ch == '-')
                {
                    num3 = num1-num2;
                    stack.push(num3);
                    System.out.println("- Operator");         
                }
                else if(ch == '/')
                {
                    num3 = num1/num2;
                    stack.push(num3);
                    System.out.println("/ Operator");         
                }
                else if(ch == '*')
                {
                    num3 = num1*num2;
                    stack.push(num3);
                    System.out.println("* Operator");         
                }
                else if(ch == '%')
                {
                    num3 = num1%num2;
                    stack.push(num3);
                    System.out.println("% Operator");    
                }
            }
        }
        System.out.println("The final answer is " + stack.pop());
   }
}
