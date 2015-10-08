package mazetester;

import java.util.Stack;

public class MazeTester
{
	private class Coor
    {
        private int row;
        private int col;
        private boolean wall;
        private boolean visited;
        private Coor(int row,int col,boolean wall,boolean visited)
        {
            this.row = row;
            this.col = col;
            this.wall = wall;
            this.visited = visited;
        }
    }
	private class Maze
	{
		private Coor start;
		private Coor end;
		private int rows;
		private int cols;
		private Coor[][] maze;
		private Maze(Coor maze[][],int rows,int cols, Coor start,Coor end)
		{
			this.rows = rows;
			this.cols = cols;
			this.start = start;
			this.end = end;
			this.maze = maze;
		}
	}
	
	private Maze theMaze;
        private Stack<Coor> stack = new Stack<>();
	
	public void CreateMaze(int maze[][],int startrow, int startcol, int endrow, int endcol)
	{
		Coor start = new Coor(startrow,startcol,false,false);
		Coor end = new Coor(endrow,endcol,false,false);
		int rows = maze.length;
		int cols = maze[0].length;
		Coor cmaze[][] = new Coor[rows][cols];
		for (int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(maze[i][j] == 1)
				{
					cmaze[i][j] = new Coor(i,j,true,false);
				}
				else
				{
					cmaze[i][j] = new Coor(i,j,false,false);
				}
			}
		}
		Maze tmpmaze = new Maze(cmaze,rows,cols,start,end);
		theMaze = tmpmaze;
	}
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
	System.out.println("The maze begins at row " + theMaze.start.row + " col " + theMaze.start.col		
               + " and ends at row " + theMaze.end.row + " col " + theMaze.end.col);
        }
    public boolean MazeRun()
    {
       stack.push(theMaze.start);
       while(stack.isEmpty() == false)
       {
            Coor location = stack.pop();
            int locrow = location.row;
            int loccol = location.col;
            theMaze.maze[locrow][loccol].visited = true;
            if(locrow+1 >= theMaze.rows == false)
            {
                Coor downcheck = theMaze.maze[locrow+1][loccol];
                if(downcheck.row == theMaze.end.row && downcheck.col == theMaze.end.col)
                    return true;
                else if(downcheck.visited == false && downcheck.wall == false)
                {
                    stack.push(downcheck);
                }
            }
            if(loccol+1 >= theMaze.cols == false)
            {
                Coor rightcheck = theMaze.maze[locrow][loccol+1];
                if(rightcheck.row == theMaze.end.row && rightcheck.col == theMaze.end.col)
                    return true;
                else if(rightcheck.visited == false && rightcheck.wall == false)
                {
                    stack.push(rightcheck);
                }
            }
            if(locrow-1 >= 0)
            {
                Coor upcheck = theMaze.maze[locrow-1][loccol];
                if(upcheck.row == theMaze.end.row && upcheck.col == theMaze.end.col)
                    return true;
                else if(upcheck.visited == false && upcheck.wall == false)
                {
                    stack.push(upcheck);
                }
            }
            if(loccol-1 >= 0)
            {
                Coor leftcheck = theMaze.maze[locrow][loccol-1];
                if(leftcheck.row == theMaze.end.row && leftcheck.col == theMaze.end.col)
                    return true;
                else if(leftcheck.visited == false && leftcheck.wall == false)
                {
                    stack.push(leftcheck);
                }
            }       
       }
       return false;
    }
    public void PrintStack()
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
