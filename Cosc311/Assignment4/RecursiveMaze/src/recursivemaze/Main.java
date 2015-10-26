package recursivemaze;

public class Main 
{
    public static void main(String[] args) 
    {
        RecursiveMaze test = new RecursiveMaze();
    	test.createMaze();
    	if(test.MazeRun() == true)
        {
            System.out.println("The maze is solvable");
            test.printPath();
        }
        else
        {
            System.out.println("The maze is not solvable");
        }
    }
}