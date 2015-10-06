
package prefixreformat;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main 
{
    public static void main(String[] args)
    {
        PrefixOperator PO = new PrefixOperator();
        Scanner scan = new Scanner(System.in);
        System.out.println("Prefix Operator by Josh Yu");        
        System.out.println("Please enter your string"); 
        String input;
        while(true)
        {
            input = scan.nextLine();
            
            if(input.equals("q") == true)
                break;
            
            StringTokenizer st = new StringTokenizer(input);
            String sReversed = "";
            while (st.hasMoreTokens()) 
            {
		sReversed = st.nextToken() + " " + sReversed;
            }
	    System.out.println("Original string is : " + input);
            System.out.println("Reversed string is : " + sReversed); 
       
            
            PO.Operate(sReversed);
            System.out.println("Please enter your string"); 
        }
    }
}
