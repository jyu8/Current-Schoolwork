package mazetester;

import java.util.Scanner;
import java.io.*;
import java.util.Stack;

public class MazeTester
{
    private class Coor
    {
        private int row; //Row number of the coordinate
        private int col; //Column number of the coordinate
        private boolean wall; //True if it is a wall
        private boolean visited; //True if it is visited
        private Coor(int row,int col,boolean wall,boolean visited)
        { //Constructor for coordinate
            this.row = row;
            this.col = col;
            this.wall = wall;
            this.visited = visited;
        }
    }
    private class Maze
    {
	private Coor start; //Start coordinate of the maze
	private Coor end; //End coordinate of the maze
	private int rows; //Number of rows in the maze
	private int cols; //Number of columns in the maze
	private Coor[][] maze; //The Coordinate array that holds the maze
	private Maze(Coor maze[][],int rows,int cols, Coor start,Coor end)
	{
       	    this.rows = rows;
            this.cols = cols;
            this.start = start;
            this.end = end;
            this.maze = maze;
	}
    }
    //The maze that is created by reading the file in
    private Maze theMaze;
    //The stack of coordinates that is iterated when finding the path
    private Stack<Coor> stack = new Stack<>();
    
    //Main reads the text file and breaks the input into coordinates and creates
    //the maze for the other functions
    public void Main(MazeTester test)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file name");
        String filen = scan.nextLine();
        String fileName = filen;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            line = br.readLine();
            //Reads the size of the maze
            int row = Character.getNumericValue(line.charAt(0));
            int col = Character.getNumericValue(line.charAt(2));
            int [][] maze = new int[row][col];
            //Reads the maze in from the information
            for(int i = 0; i < row; i++)
            {
                line = br.readLine();
                for(int j = 0; j < col; j++)
                {
                    int num = Character.getNumericValue(line.charAt(j));
                    maze[i][j] = num; 
                }
            }
            //Reads in the beginning and end points
            line = br.readLine();
            int startrow = Character.getNumericValue(line.charAt(0));
            int startcol = Character.getNumericValue(line.charAt(2));
            line = br.readLine();
            int endrow = Character.getNumericValue(line.charAt(0));
            int endcol = Character.getNumericValue(line.charAt(2));
            
            //Create the Maze theMaze with the inputs from the text file
            test.CreateMaze(maze,startrow,startcol,endrow,endcol);
            test.printMaze();
            
            //Test the to see if the maze can be solved
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
    
    //Takes the inputs from the text file and generates a maze of coordinates
    //With the correct values of wall and visited, start and end
    private void CreateMaze(int maze[][],int startrow,
            int startcol,int endrow,int endcol)
    {
        //Create start and end coordinates from the inputs
        Coor start = new Coor(startrow,startcol,false,false);
	Coor end = new Coor(endrow,endcol,false,false);
	int rows = maze.length;
	int cols = maze[0].length;
	Coor cmaze[][] = new Coor[rows][cols];
        //Place all the values in from the txt file into a coordinate maze
	for (int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
		if(maze[i][j] == 1)
                    cmaze[i][j] = new Coor(i,j,true,false);
		else
                    cmaze[i][j] = new Coor(i,j,false,false);
	    }
        }
        //Initialize the maze with the all the variables
	Maze tmpmaze = new Maze(cmaze,rows,cols,start,end);
        //Copy the temporary maze into theMaze of the class
	theMaze = tmpmaze;
    }
    //Tests theMaze if if the exit can be legally found using stack functions
    private boolean MazeRun()
    {
       stack.push(theMaze.start);        //Put the start into the stack
       PrintStack();              //Print the intial stack state
       while(stack.isEmpty() == false) //Keep going until theres nothing left
       {
            Coor location = stack.pop(); //Get the coordinate of the last spot
            int locrow = location.row;
            int loccol = location.col;
            //Change the value so that the program doesn't backtrack
            theMaze.maze[locrow][loccol].visited = true; 
            //Each of the following if statements tests a direction to see if it
            //is the end. If it is not the end, it checks to see it is wall and 
            //if it is visited or not. If not, then add to the stack
            
            //Check boundry
            if(locrow+1 >= theMaze.rows == false)
            {
                Coor downcheck = theMaze.maze[locrow+1][loccol];
                //Check to see it its the end
                if(downcheck.row == theMaze.end.row 
                        && downcheck.col == theMaze.end.col)
                    return true;
                //Check to see if it is visited or wall
                else if(downcheck.visited == false && downcheck.wall == false)
                    stack.push(downcheck); //push onto stack
            }
            if(loccol+1 >= theMaze.cols == false)
            {
                Coor rightcheck = theMaze.maze[locrow][loccol+1];
                if(rightcheck.row == theMaze.end.row 
                        && rightcheck.col == theMaze.end.col)
                    return true;
                else if(rightcheck.visited == false && rightcheck.wall == false)
                    stack.push(rightcheck);
            }
            if(locrow-1 >= 0)
            {
                Coor upcheck = theMaze.maze[locrow-1][loccol];
                if(upcheck.row == theMaze.end.row 
                        && upcheck.col == theMaze.end.col)
                    return true;
                else if(upcheck.visited == false && upcheck.wall == false)
                    stack.push(upcheck);
            }
            if(loccol-1 >= 0)
            {
                Coor leftcheck = theMaze.maze[locrow][loccol-1];
                if(leftcheck.row == theMaze.end.row
                        && leftcheck.col == theMaze.end.col)
                    return true;
                else if(leftcheck.visited == false && leftcheck.wall == false)
                    stack.push(leftcheck);
            }
            PrintStack();
       }
       //If the bottom of the stack was reached without finding the end,
       //then the maze is not solvable
       return false;
    }
    //Prints out theMaze with 1 being a wall, 0 being path, B is beginning,
    //E is the end, and V is the spaces that were visited on the path
    private void printMaze()
    {
        for(int i = 0; i < theMaze.rows; i++)
        {
            for(int j = 0; j < theMaze.cols;j++)
            {
                Coor tmp = theMaze.maze[i][j];
                if(tmp.wall == true)
                    System.out.print("1");
                else if(tmp.row == theMaze.end.row
                    && tmp.col == theMaze.end.col)
                     System.out.print("E");
                else if(tmp.row == theMaze.start.row
                    && tmp.col == theMaze.start.col)
                    System.out.print("B");
                else if(tmp.visited == true)
                    System.out.print("V");
                else
                    System.out.print("0");
            }
        System.out.println();
        }
        System.out.println("The maze begins at row " + theMaze.start.row +
            " col " + theMaze.start.col		
           + " and ends at row " + theMaze.end.row + " col " + theMaze.end.col);
    }
    //Tester that prints the elements of the stack in the correct order
    private void PrintStack()
    {
        Stack<Coor> copystack = (Stack<Coor>)stack.clone();
        
        System.out.println("The Top");
        while(copystack.isEmpty() == false)
        {
            Coor temp;
            temp = copystack.pop();
            System.out.println(temp.row + " " + temp.col);
        }
        System.out.println("The Bottom");
    }
}
