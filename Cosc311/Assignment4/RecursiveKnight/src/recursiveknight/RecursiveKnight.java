/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursiveknight;

/**
 *
 * @author Josh
 */
public class RecursiveKnight 
{
    private int[][] board; //Array of ints for the board
    private boolean [][] visit; //Array if the space has been visited
    private int height, width; //Height and width of the board
    private int startx, starty; //starting location of the run
    private int maxmoves; //Max moves to fill the board
    
    //public constructor for the board
    public void makeBoard(int h, int w, int col, int row)
    {
        height = h;
        width = w;
        board = new int[height][width];
        visit = new boolean[height][width];
        starty = col;
        startx = row;
        maxmoves = height*width; 
    }
    
    //Loops through the board and prints it along with row, col, start values
    public void printBoard()
    {
        System.out.println("Rows:" + height);
        System.out.println("Cols:" + width);
        System.out.println("Start: (" + starty + "," + startx + ")");
        
        System.out.println("Output:");
        for(int i = 0; i< height;i++)
        {
            for (int j = 0; j < width; j++)
            {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }
    
    //public boolean that returns if the board can be filled
    public boolean move()
    {
        return move(startx,starty,1); //movenum is 1 for the first move
    }
    //private boolean that takes a coordinate and a movenum and checks around
    //to see if there is a valid move
    private boolean move(int x,int y,int movenum)
    {
        //checks to see if the the value is out of bounds
        if (x < 0 || x > (width-1) || y < 0 || y > (height-1) )
        {
            return false;
        }
        //if it has been visited before go back
        if (visit[y][x] == true)
        {
            return false;
        }
        //once the board has been filled, return true and set the value 
        if(movenum == maxmoves)
        {
            visit[y][x] = true;
            board[y][x] = movenum;
            return true;
        }
        //If coordinate is valid and board has not been filled, start chekcing
        else
        {
            visit [y][x] = true; //set coordinate to true for future calls
            boolean finished = false; //boolean if the end has been found
            
            //movenum is incremented if a valid position is found
            if(finished == false)
                finished = move(x+2,y+1,movenum+1); //right 2 up 1
            if(finished == false)
                finished = move(x+2,y-1,movenum+1);//right 2 down 1
            if(finished == false)
                finished = move(x+1,y+2,movenum+1);//right 1 up 2
            if(finished == false)
                finished = move(x+1,y-2,movenum+1);//right 1 down 2
            if(finished == false)
                finished = move(x-1,y+2,movenum+1);//left 1 up 2
            if(finished == false)
                finished = move(x-1,y-2,movenum+1);//left 1 down 2
            if(finished == false)
                finished = move(x-2,y+1,movenum+1);//left 2 up 1
            if(finished == false)
                finished = move(x-2,y-1,movenum+1);//left 2 down 1
            
            //If the ending was found, put the move number onto the board 
            if(finished == true)
            {
                board[y][x] = movenum;
                return true;
            }
            //if none of these were valid reset the coordinate and step back 
            else
            {
                visit[y][x] = false;
                return false;
            }
        }
      
    }
    
}
