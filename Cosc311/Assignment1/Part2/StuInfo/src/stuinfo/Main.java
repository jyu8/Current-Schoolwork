package stuinfo;
import java.util.Scanner;
import java.io.*;
/**
 * @author Josh
 */
public class Main
{
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
                System.out.println("Enter the student age");
                int y = S.nextInt();
                System.out.println("Enter the gpa");
                double z = S.nextDouble();
                database.add(w,x,y,z);
            }
            else if (n == 'b')
            {
                System.out.println("Enter the ID number");
                int w = S.nextInt();
                database.remove(w);
            }
            else if (n == 'c')
            {
                System.out.println("Enter the ID number");
                int w = S.nextInt();
                database.displayinfo(database.get(database.find(w)));
            }
            else if (n == 'd')
            {
                database.display();
            }
            else if (n == 'e')
            {
                database.display();
            }
            else if (n == 'f')
            {
                System.out.println("Enter the file name");
                String x = scan.nextLine();
                String fileName = x;
                String line = null;
                try 
                {
                    FileReader fileReader = new FileReader(fileName);
                    BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);
                    while((line = bufferedReader.readLine()) != null) 
                        System.out.println(line);   
                    bufferedReader.close();         
                }
                catch(FileNotFoundException ex) 
                {
                    System.out.println("Unable to open file '"
                        + fileName + "'");  
                }
                catch(IOException ex) 
                {
                    System.out.println("Error reading file '" + fileName + "'");                  
        
                }
            }
        }
    }
}

