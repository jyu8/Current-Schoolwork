/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stuinfo;
import java.util.Scanner;
/**
 *
 * @author Josh
 */
public class StuInfoTester {
     public static void main(String[] args)
    {
        Scanner S = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        StuInfo database = new StuInfo();
        char n = 'n'; 
        while (n != 'g')
        {
            System.out.println("Welcome to the University Student Information"
                + " Database");
            System.out.println("Please choose an option");
            System.out.println("A) to add a student");
            System.out.println("B) to delete a student");
            System.out.println("C) to find a student by ID");
            System.out.println("D) to show all students by ID");
            System.out.println("E) to save all students to a .txt file");
            System.out.println("F) to load students from a .txt file");
            System.out.println("G) to exit");
            n = S.next(".").charAt(0);
            if (n == 'a')
            {
                System.out.println("Enter the ID number");
                int w = S.nextInt();
                System.out.println("Enter the last name");
                String x = scan.nextLine();
                System.out.println(x);
                System.out.println("Enter the student age");
                int y = S.nextInt();
                System.out.println("Enter the gpa");
                int z = S.nextInt();
                database.add(w,x,y,z);
            }
        }
    }
}

