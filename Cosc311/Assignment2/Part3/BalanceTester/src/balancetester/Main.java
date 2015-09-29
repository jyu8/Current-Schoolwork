package balancetester;

public class Main
{
    public static void main(String[] args)
    {
        BalanceTester  test = new BalanceTester();
        boolean answer;
        answer = BalanceTester.isBalanced("x + ([y - x * z] + {y + z}/5 + 10)/2");
        System.out.println(answer);
        answer = BalanceTester.isBalanced("(x * [3 + y) + (5+7)/z)");
        System.out.println(answer);
    }
}