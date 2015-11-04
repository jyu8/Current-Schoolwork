
import java.util.Random;

public class RecursiveArray
{
    private int[] array;
    private int size;
    private final int capacity = 20;
    
    public RecursiveArray()
    {
    	array = new int[capacity];
    	size = 0;
    }
    
    //creates an array of 20 random numbers
    public void makeArray(int num)
    {
    	makeArray(num,0);
    } 
    private void makeArray(int num,int index)
    {
        if(num != 0)
        {
            Random rn = new Random();
            int randomNum = rn.nextInt(100 - 0 + 1) + 0;
            array[index] = randomNum;
            size++;
            makeArray(num-1,index+1);
        }
    }
    
    //displays the array
    public void display()
    {
    	display(0);
    }
    
    private void display(int num)
    {
        if(num < size)
        {
            System.out.println(array[num]);
            display(num+1);
        }
    }

    //returns the sum of the array
    public int sum()
    {
        return sum(0,0,size);
    }
    private int sum(int sum, int index,int arraysize)
    {
        if(arraysize == 0)
            return sum;
        else
        {
            return sum(sum + array[index],index+1,arraysize-1);
        }
    }

    //returns true if there is a zero in the array
    public boolean zeroFinder()
    {
        return zeroFinder(0);
    }
    private boolean zeroFinder(int index)
    {
        if(index == size)
        	return false;
        else if(array[index] == 0)
        	return true;
        else
        	return zeroFinder(index+1);
    }
    //prints the odd elements of the array
    public void oddPrinter()
    {
        oddPrinter(0);
    }
    private void oddPrinter(int index)  
    {
        if(index != size)
        {
        	if(array[index] % 2 == 0)
        		oddPrinter(index+1);
            else
            {
                System.out.println(array[index]);
                oddPrinter(index+1); 
            }          
        }
    }
    //prints every other element in the array
    public void skipPrint()
    {
        skipPrint(0);
    }
    private void skipPrint(int index)
    {
        if(index != size)
        {
            System.out.println(array[index]);
            skipPrint(index + 2);
        }
    }
    //prints the array in reverse order
    public void reversePrint()
    {
        reversePrint(size-1);
    }
    public void reversePrint(int index)
    {
        if (index != -1)
        {
            System.out.println(array[index]);
            reversePrint(index -1);
        }
    }
    
}