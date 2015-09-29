package balancetester;
import java.util.Stack;

public class BalanceTester 
{
    public static boolean isBalanced(String input)
    {
        Stack<Character> stack = new Stack<>();
        char ch;
        int index = 0;
        boolean balanced = true;
        
        while(index < input.length())
        {
            ch = input.charAt(index);
            if(ch == '(' || ch == '[' || ch == '{')
            {
                stack.push(ch);
            }   
            else if(ch == ')'||  ch == ']' || ch == '}')
            {
                if(stack.isEmpty() || !match(stack.pop(),ch))
                {
                    balanced = false;
                    break;
                }
            }
            index++;
        }
        return(balanced && stack.isEmpty());
    }
    private static boolean match(char left, char right)
    {
        return (left == '(' && right == ')') || (left == '[' && right == ']')
                || (left == '{' && right == '}');
    }
}

