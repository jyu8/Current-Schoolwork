//Author: Josh Yu

package prefixreformat;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class PrefixOperator 
{   
    //Main prints out the starting message and reverse tokenizes the string
    //Essentially changes the string from prefix to postfix format for Operate
    public void Main(PrefixOperator PO)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Prefix Operator by Josh Yu");        
        System.out.println("Please enter your string"); 
        String input;
        while(true)
        {
            input = scan.nextLine();
            if(input.equals("q") == true) //Break statement when q is entered
                break;
            
            StringTokenizer st = new StringTokenizer(input);
            String sReversed = "";
            //This loop feeds the tokens from the input and reverses it into 
            //String sReversed
            while (st.hasMoreTokens()) 
            {
		sReversed = st.nextToken() + " " + sReversed;
            }
	    System.out.println("Original string is : " + input);
            System.out.println("Reversed string is : " + sReversed); 
            //Perform the operation on the reversed string
            PO.Operate(sReversed); 
            System.out.println("Please enter your string");  
        }
    }
    //Operates on reversed string providing the answer to valid answer to 
    //postfix operator strings
    private void Operate(String input)
    {
        Stack<Object> stack = new Stack<Object>();
        StringTokenizer st = new StringTokenizer(input);
        Object temp;
        while (st.hasMoreTokens())//Keeps operating on the stack
        {
            temp = st.nextElement();
            String tmpstr = temp.toString();
            //Tests if the token is a character
            if(Character.isDigit(tmpstr.charAt(0)))
            {   
                int foo = Integer.parseInt(tmpstr);
                stack.push(foo); //Push onto stack if it is a digit
                System.out.println("Pushed Int: " + foo);
            }
            else //If the token is an operator
            {
                int num1 = (int)stack.pop();
                int num2 = (int)stack.pop();
                int num3;
                char ch = tmpstr.charAt(0);
                //Then perform the correct operation with two popped elements 
                //from stack and then push the result back onto the stack
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
