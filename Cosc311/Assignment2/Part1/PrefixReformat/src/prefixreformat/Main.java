
package prefixreformat;


public class Main 
{
    public static void main(String[] args)
    {
        boolean answer;
        answer = isBalanced("x + ([y - x * z] + {y + z}/5 + 10)/2");
        System.out.println(answer);
        answer = isBalanced("(x * [3 + y) + (5+7)/z)");
        System.out.println(answer);
    }
}
