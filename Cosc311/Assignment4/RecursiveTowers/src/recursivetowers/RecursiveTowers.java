
public class RecursiveTowers {
    
    //splits disks from a bicolor stack on origin into two colored stacks
    //with the white on dest and the back on temp
    //returns the number of moves used to do so
    
    //n - number of disks that are moved
    //origin - origin pole
    //dest - destination pole
    //temp - temporary pole
    public static int split(int n,char origin,char dest,char temp)
    {
        int moves = 0; //move counter
        if(n == 1) //base case if there is only 1 set to split
        {
            System.out.println("Move White Disk 1 from "+origin+" to "+dest);
            System.out.println("Move Black Disk 1 from "+origin+" to "+temp);
            moves +=2; //2 moves to split 1 pair
        }
        else
        {
            //move n-1 pairs from origin to temp
            moves += move(n-1,origin,temp,dest);
            
            //move the bottom disk from origin to dest
            System.out.println("Move White Disk "+n+" from "+origin+" to "+dest);
            moves++;
            
            //move the n-1 paris from temp to dest on top of the bottom white disk
            moves += move(n-1,temp,dest,origin);
            
            //move the bottom black disk from origin to temp
            System.out.println("Move Black Disk "+n+" from "+origin+" to "+temp);
            moves++;
            
            //move the n-1 pairs on top of bottom white disk back to origin
            moves += move(n-1,dest,origin,temp);
            
            //call again to split the rest of the stack
            moves += split(n-1,origin,dest,temp);
        }
        return moves; 
    }
    
    //moves a bicolored stack from origin to dest using temp while preserving 
    //which disk is on top i.e. W1 on B1 on origin is W1 on B1 on dest
    //returns the number of moves used to do so
    public static int move(int n,char origin,char dest,char temp)
    {
        int moves = 0; //moves keeps track of how many moves are used
        
        if(n > 0) //In the case of n = 0, do nothing
        {
            //move n-1 disks from origin to dest
            moves += move(n-1,origin,dest,temp);
            
            //move bottom disk pair from origin to temp
            //they are in reverse order at this point
            System.out.println("Move White Disk "+n+" from "+origin+" to "+temp);
            System.out.println("Move Black Disk "+n+" from "+origin+" to "+temp);
            moves +=2;
            
            //move the n-1 pairs from dest to origin 
            moves += move(n-1,dest,origin,temp);
            
            //move the bottom disk pair from temp to dest
            //the bottom pair is in correct order at this point
            System.out.println("Move Black Disk "+n+" from "+temp+" to "+dest);
            System.out.println("Move White Disk "+n+" from "+temp+" to "+dest);
            moves+=2;
            
            //take care of the rest n-1 pairs in this way
            moves += move(n-1,origin,dest,temp); 
        }
        return moves;
    }

    public static void main(String[] args) 
    {   
        //print out the amount of moves needed to do this
        System.out.println("MOVES:"+ split(10,'A','B','C'));
    }
    
}