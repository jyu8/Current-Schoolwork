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
    private int[][] board;
    private boolean [][] visit;
    private int height, width;
    private int startx, starty;
    private int maxmoves;
    
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
    
    public boolean move()
    {
        return move(startx,starty,1);
    }
    private boolean move(int x,int y,int movenum)
    {
        //System.out.println("check:" + movenum + "at:" + y + x);
        if (x < 0 || x > (width-1) || y < 0 || y > (height-1) )
        {
            return false;
        }
        if (visit[y][x] == true)
        {
            return false;
        }
        if(movenum == maxmoves)
        {
            visit[y][x] = true;
            board[y][x] = movenum;
            return true;
        }
        else
        {
            visit [y][x] = true;
            boolean finished = false;
            if(finished == false)
                finished = move(x+2,y+1,movenum+1);
            if(finished == false)
                finished = move(x+2,y-1,movenum+1);
            if(finished == false)
                finished = move(x-2,y+1,movenum+1);
            if(finished == false)
                finished = move(x-2,y-1,movenum+1);
            if(finished == false)
                finished = move(x+1,y+2,movenum+1);
            if(finished == false)
                finished = move(x+1,y-2,movenum+1);
            if(finished == false)
                finished = move(x-1,y+2,movenum+1);
            if(finished == false)
                finished = move(x-1,y-2,movenum+1);
            
            if(finished == true)
            {
                board[y][x] = movenum;
                return true;
            }
            else
            {
                visit[y][x] = false;
                return false;
            }
        }
      
    }
    
}
