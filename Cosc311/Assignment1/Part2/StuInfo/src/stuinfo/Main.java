package stuinfo;
import java.util.Scanner;
import java.io.*;
//Author: Josh Yu
public class Main
{
     public static void main(String[] args)
    {
        Scanner S = new Scanner(System.in); //Scanner for inputs
        Scanner scan = new Scanner(System.in); //Scanner for strings
        StuInfo database = new StuInfo();
        char n = 'z'; 
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
                int ID = S.nextInt();
                System.out.println("Enter the last name");
                String lname = scan.nextLine();
                System.out.println("Enter the student age");
                int age = S.nextInt();
                System.out.println("Enter the gpa");
                double gpa = S.nextDouble();
                database.add(ID,lname,age,gpa);
            }
            else if (n == 'b')
            {
                System.out.println("Enter the ID number");
                int ID = S.nextInt();
                database.remove(ID);
            }
            else if (n == 'c')
            {
                System.out.println("Enter the ID number");
                int ID = S.nextInt();
                database.displayinfo(database.get(database.find(ID)));
            }
            else if (n == 'd')
            {
                database.display();
            }
            else if (n == 'e')
            {
                System.out.println("Enter the file name");
                String x = scan.nextLine();
                String fileName = x;
                try 
                {
                    FileWriter fileWriter = new FileWriter(fileName);
                    try (BufferedWriter bufferedWriter = 
                            new BufferedWriter(fileWriter)) 
                    {
                        int i = 0;
                        while(i < database.size)
                        {
                            bufferedWriter.write(database.PrintInfo(database.get(i)));
                            bufferedWriter.newLine();
                            i++;
                        }             
                    }
                }
                catch(IOException ex) 
                {
                    System.out.println( "Error writing to file '"
                            + fileName + "'");
                }
            }
            else if (n == 'f')
            {
                database.RemoveAll();
                System.out.println("Enter the file name");
                String filen = scan.nextLine();
                String fileName = filen;
                String line = null;
                try 
                {
                    FileReader fileReader = new FileReader(fileName);
                    try (BufferedReader bufferedReader = 
                            new BufferedReader(fileReader)) {
                        while((line = bufferedReader.readLine()) != null)
                        {
                            String[] arrayLine= line.split("\\s+"); 
                            int ID = Integer.parseInt(arrayLine[0]);
                            String lname = arrayLine[1];
                            int age  = Integer.parseInt(arrayLine[2]);
                            Double gpa = Double.parseDouble(arrayLine[3]);
                            database.add(ID,lname,age,gpa);
                        }
                    }         
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

