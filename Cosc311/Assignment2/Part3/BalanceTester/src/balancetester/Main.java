
package balancetester;

import java.util.Scanner;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        BalanceTester BTester = new BalanceTester();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file name");
        String filen = scan.nextLine();
        String fileName = filen;
        int linenum = 1;
        Boolean balanced = true;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                balanced = BTester.isBalanced(line,linenum);
                if(balanced == false)
                {
                    break;
                }
                linenum++;
            }
            if(balanced == true)
                BTester.endcheck();
        }         
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file '" + fileName + "'");  
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
    
    }
}