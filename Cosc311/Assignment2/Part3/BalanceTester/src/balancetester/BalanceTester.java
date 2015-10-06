package balancetester;
import java.util.Stack;

public class BalanceTester 
{
    private class Input
    {
        private int linenum;
        private char ch;
        private Input(char inputchar,int linenum)
        {
            this.ch = inputchar;
            this.linenum = linenum;
        }
    }
    
    private Stack<Input> stack = new Stack<Input>();
    
    public boolean isBalanced(String input,int linenum)
    {
        char ch;
        int index = 0;
        boolean balanced = true;
        
        while(index < input.length())
        {
            ch = input.charAt(index);
            Input getin;
            getin = new Input(ch,linenum);
            if(ch == '(' || ch == '[' || ch == '{')
            {
                System.out.println("Pushed " + Getch(getin) + " at line " + Getlinenum(getin));
                stack.push(getin);
            }   
            else if(ch == ')'||  ch == ']' || ch == '}')
            {
                if(stack.isEmpty())
                {
                    System.out.println("Unmatched right symbol: " + ch + " at line: " + linenum);
                    balanced = false;
                    break;
                }
                else 
                {
                    Input tmp = stack.pop();
                    if(!match(Getch(tmp),ch))
                    {
                        System.out.println("Mismatch error:");
                        System.out.println(Getch(tmp) + " from line " + Getlinenum(tmp)
                        + " and "  + ch+" from line "+ linenum 
                        + " do not match");
                        balanced = false;
                        break; 
                    }
                    else
                    {
                        System.out.println("Matched and popped " + Getch(tmp)
                        + " from line " + Getlinenum(tmp) + " with " + ch +
                        " from " + linenum);
                    }   
                }
            }
            index++;
        }
        return(balanced);
    }
    public void endcheck()
    {
        if(stack.isEmpty() == false)
        {
            Input temp;
            temp = stack.pop();
            System.out.println("Unmatched symbol: " + Getch(temp) + " at line: " + Getlinenum(temp));
        }
        else
        {
            System.out.println("Expression is balanced");
        }
    }
    private static boolean match(char left, char right)
    {
        return (left == '(' && right == ')') || (left == '[' && right == ']')
                || (left == '{' && right == '}');
    }
    private char Getch(Input input)
    {
        return input.ch;
    }
    private int Getlinenum(Input input)
    {
        return input.linenum;
    }
}
