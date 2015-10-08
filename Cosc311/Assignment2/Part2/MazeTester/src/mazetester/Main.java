
package mazetester;

import java.util.Scanner;
import java.io.*;

public class Main 
{
    public static void main(String[] args) 
    {
    	MazeTester test = new MazeTester();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file name");
        String filen = scan.nextLine();
        String fileName = filen;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            line = br.readLine();
            int row = Character.getNumericValue(line.charAt(0));
            int col = Character.getNumericValue(line.charAt(2));
            int [][] maze = new int[row][col];
            for(int i = 0; i < row; i++)
            {
                line = br.readLine();
                for(int j = 0; j < col; j++)
                {
                    int num = Character.getNumericValue(line.charAt(j));
                    maze[i][j] = num; 
                }
            }
            line = br.readLine();
            int startrow = Character.getNumericValue(line.charAt(0));
            int startcol = Character.getNumericValue(line.charAt(2));
            line = br.readLine();
            int endrow = Character.getNumericValue(line.charAt(0));
            int endcol = Character.getNumericValue(line.charAt(2));
            
            test.CreateMaze(maze,startrow,startcol,endrow,endcol);
            test.printMaze();
            
            if(test.MazeRun() == true)
            {
                System.out.println("The maze is solvable");
            }
            else
            {
                System.out.println("The maze is not solvable");
            }
            test.printMaze();
        }         
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file '" + fileName + "'");  
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
        scan.close();
    }
}
