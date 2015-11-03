/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivetowers;

/**
 *
 * @author Josh
 */
public class RecursiveTowers {
    
    public static void split(int n, char origin, char dest, char temp,int moves)
    {
        if(n == 1)
        {
            
        }
    }
    public static void move(int n, char origin, char dest, char temp, int moves)
    {
        if(n > 0)
        {
            move(n-1,origin,dest,temp,moves);
            System.out.println("Move Disk White " +n+ " from "+origin+" to "+temp);
            System.out.println("Move Disk Black " +n+ " from "+origin+" to "+temp);
            move(n-1,dest,origin,temp,moves);
            System.out.println("Move Disk Black " +n+ " from "+temp+" to "+dest);
            System.out.println("Move Disk White " +n+ " from "+temp+" to "+dest);
            move(n-1,origin,dest,temp,moves);
        }
    }

    public static void main(String[] args) 
    {   
       move(2,'A','B','C',0);
    }
    
}
