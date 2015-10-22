/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivelist;

import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class Main
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        RecursiveList List = new RecursiveList();
        char n = 'z';
        while (n != 'h')
        {
            System.out.println("Please choose an option");
            System.out.println("A) to create a list of 20 in the 0-100 range");
            System.out.println("B) to print the list");
            System.out.println("C) to find the sum of the list");
            System.out.println("D) to test if the list contains zero");
            System.out.println("E) to print all odd numbers in the list");
            System.out.println("F) to print every other element");
            System.out.println("G) to print the elements in reverse order");
            System.out.println("H) to exit");
            n = scan.next(".").charAt(0);
            if(n == 'a')
                List.add(20);
            if(n == 'b')
                List.display();
            if(n == 'c')
                System.out.println("Sum:" +List.sum());
            if(n == 'd')
                System.out.println("Zero in the list?: " + List.zeroFinder());
            if(n == 'e')
                List.oddPrinter();
            if(n == 'f')
                List.skipPrint();
            if(n == 'g')
                List.reversePrint();
            
            System.out.println();
        }
    }
}
