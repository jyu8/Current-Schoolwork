package balancetester;

import java.util.Scanner;
import java.io.*;
import java.util.Stack;

public class BalanceTester 
{
    private class Input
    {
        private int linenum; //Stores the linenumber of the bracket
        private char ch; //Stores the specific char of the bracket
        private Input(char inputchar,int linenum) //Constructor for input
        {
            this.ch = inputchar;
            this.linenum = linenum;
        }
    }
    //Makes a private stack to push and pop brackets onto and off
    private Stack<Input> stack = new Stack<Input>();
    
    //Main opens the file and tests for balance in the brackets
    public void Main(BalanceTester BTester)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file name");
        String filen = scan.nextLine();
        String fileName = filen;
        int linenum = 1;
        Boolean balanced = true;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            //Keeps reading in until the end of the file
            while((line = br.readLine()) != null)
            {
                //Check if balance is broken after every char is added
                balanced = BTester.isBalanced(line,linenum);
                if(balanced == false) //Exit once balance is broken
                {
                    break;
                }
                linenum++;
            }
            //If the end of the file is reached and balance is there, check to 
            //see if the last element breaks the balance
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
    //Takes the string and tests for balance within the string while pushing
    //all brackets onto the stack with the linenum
    private boolean isBalanced(String input,int linenum)
    {
        char ch;
        int index = 0;
        boolean balanced = true;
        //Iterate through the entire string for brackets
        while(index < input.length())
        {
            ch = input.charAt(index);
            Input getin;
            getin = new Input(ch,linenum);
            //If the bracket is a left bracket
            if(ch == '(' || ch == '[' || ch == '{')
            {
                System.out.println("Pushed " + getin.ch
                        + " at line " + getin.linenum);
                stack.push(getin); //Push it onto the stack
            }
            //If the bracket is a right bracket
            else if(ch == ')'||  ch == ']' || ch == '}')
            {
                //Error case right bracket with no left brackets in the stack
                if(stack.isEmpty())
                {
                    System.out.println("Unmatched right symbol: " 
                            + ch + " at line: " + linenum);
                    balanced = false;
                    break;
                }
                else 
                {
                    Input tmp = stack.pop();
                    //Error case last bracket on the stack does not match
                    if(!match(tmp.ch,ch))
                    {
                        System.out.println("Mismatch error:");
                        System.out.println(tmp.ch + " from line " + 
                        tmp.linenum + " and "  + ch+" from line "+ linenum 
                        + " do not match");
                        balanced = false;
                        break; 
                    }
                    else //If the right bracket matches the left bracket
                    {
                        System.out.println("Matched and popped " + tmp.ch
                        + " from line " + tmp.linenum + " with " + ch +
                        " from " + linenum);
                    }   
                }
            }
            //If the char is not a bracket then keep going
            index++;
        }
        return(balanced);
    }
    //Checks to make sure that the stack is empty gives the right error if not
    private void endcheck()
    {
        //Error case there are residual left brackets on the stack at the end
        if(stack.isEmpty() == false)
        {
            Input temp;
            temp = stack.pop();
            //Error message with the last bracket on stack
            System.out.println("Unmatched symbol: " + temp.ch
                    + " at line: " + temp.linenum);
        }
        else
        {
            System.out.println("Expression is balanced");
        }
    }
    //Takes two chars and is true if the brackets for a pair
    private static boolean match(char left, char right)
    {
        return (left == '(' && right == ')') || (left == '[' && right == ']')
                || (left == '{' && right == '}');
    }
}
