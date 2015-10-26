package recursivemaze;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


public class RecursiveMaze
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
    private ArrayList<Coor> pathlist = new ArrayList();

    
    public void createMaze()
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
            CreateMaze(maze,startrow,startcol,endrow,endcol);
            printMaze();
            
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
    public boolean MazeRun()
    {
        return MazeRun(theMaze.start);
    }
    private boolean MazeRun(Coor start)
    {
        boolean finished = false;
        start.visited = true;
        if(start.col == theMaze.end.col && start.row == theMaze.end.row)
        {
            finished = true; 
        }
        else
        {
            if(start.row+1 >= theMaze.rows == false && finished == false)
            {
                Coor downcheck = theMaze.maze[start.row+1][start.col];
                if(downcheck.visited == false && downcheck.wall == false)
                {
                    finished = MazeRun(downcheck);
                }
            }
            if(start.col+1 >= theMaze.cols == false && finished == false)
            {
                Coor rightcheck = theMaze.maze[start.row][start.col+1];
                if(rightcheck.visited == false && rightcheck.wall == false)
                {
                    finished = MazeRun(rightcheck);
                }
            }
            if(start.row-1 >= 0 && finished == false)
            {
                Coor upcheck = theMaze.maze[start.row-1][start.col];
                if(upcheck.visited == false && upcheck.wall == false)
                {
                    finished = MazeRun(upcheck);
                }
            }
            if(start.col-1 >= 0 && finished == false)
            {
                Coor leftcheck = theMaze.maze[start.row][start.col-1];
                if(leftcheck.visited == false && leftcheck.wall == false)
                {
                    finished = MazeRun(leftcheck);
                }
            }
        }
        if(finished == true)
            pathlist.add(start);
        return finished;
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
    public void printPath()
    {
        System.out.print("Path: ");
        printPath(pathlist.size()-1);
        System.out.println();
    }
    private void printPath(int size)
    {
        if(size != -1)
        {
            System.out.print("("+pathlist.get(size).row+","+pathlist.get(size).col+")");
            printPath(size-1);
        }
        
    }
    //Prints out theMaze with 1 being a wall, 0 being path, B is beginning,
    //E is the end, and V is the spaces that were visited on the path
    public void printMaze()
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
}