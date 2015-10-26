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

    public static void move(int n, char origin, char dest, char temp)
    {
        if( n == 1)
            System.out.println("move disk 1 from " + origin + " to " + dest);
        else
        {
            move(n-1, origin, temp, dest);
            
            System.out.println("move disk " + n + " from " + origin + " to " + dest);
            
            move(n-1, temp, dest, origin);
        }
    }
    public static void split(int n, char origin, char dest, char temp)
    {
        if(n == 1)
        {
            System.out.println("Move White 1 from " + origin + " to " + dest);
            System.out.println("Move Black 1 from " + origin + " to " + temp);
        }
    }
    public static void doubletowers(char origin, char dest, char temp, int n)
    {
        if(n == 1)
        {
            System.out.println("Move disk 1W from " + origin + " to " + dest);
            System.out.println("Move disk 1B from " + origin + " to " + dest);
        }
        else
        {
            doubletowers(origin,  temp, dest , n-1);
            System.out.println("move disk " + n + "W from " + origin + " to " + dest);
            System.out.println("move disk " + n + "B from " + origin + " to " + dest);
            doubletowers(temp,dest,origin,n-1);
        }       
    }
    public static void call(char origin, char dest, char temp, int n)
    {
        doubletowers(origin,temp,dest,n);
        doubletowers(temp,dest,origin,n);
    }
    public static void main(String[] args) 
    {   
        call('A' , 'B' , 'C',1);
    }
    
}
