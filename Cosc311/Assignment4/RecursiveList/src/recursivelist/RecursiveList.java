

import java.util.Random;
/**
 *
 * @author Josh
 */
public class RecursiveList 
{
    private class Node
    {
        private Object data;
        private Node next;

        private Node(Object data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    public RecursiveList()
    {
        head = null;
    }
    //adds 20 random elements to the list
    public void add(int num)
    {
        if(num != 0)
        {
            Random rn = new Random();
            int randomNum = rn.nextInt(100 - 0 + 1) + 0;
            Node datanode = new Node(randomNum, null); 
            
            Node tmp = head;
            if(head != null)
            {
                while(tmp.next != null)
                {
                    tmp = tmp.next;
                }
                tmp.next = datanode; 
            }
            else
            {
                head = datanode;
            }
            add(num-1);
        }
    }
    //prints the list
    public void display()
    {
        display(head);
    }
    private void display(Node p)
    {
        if(p != null)
        {
            System.out.println(p.data);
            display(p.next);
        }
    }
    //adds all 20 together
    public int sum()
    {
        return sum(head);
    }
    private int sum(Node p)
    {
        if(p == null)
            return 0;
        else
        {
            return sum(p.next)+(int)p.data;
        }
    }
    //returns true if there is a 0
    public boolean zeroFinder()
    {
        return zeroFinder(head);
    }
    private boolean zeroFinder(Node p)
    {
        if(p == null)
           return false;
        else if((int)p.data == 0)
            return true;
        else
            return zeroFinder(p.next);  
    }
    //prints all odd elements of the array
    public void oddPrinter()
    {
        oddPrinter(head);
    }
    private void oddPrinter(Node p)  
    {
        if(p != null)
        {
            if((int)p.data %2 == 0)
                oddPrinter(p.next);
            else
            {
                System.out.println(p.data);
                oddPrinter(p.next); 
            }          
        }
    }
    //prints every other in the array
    public void skipPrint()
    {
        skipPrint(head);
    }
    private void skipPrint(Node p)
    {
        if(p != null)
        {
            System.out.println(p.data);
            skipPrint(p.next.next);
        }
    }
    //prints the array in reverse order
    public void reversePrint()
    {
        reversePrint(head);
    }
    public void reversePrint(Node p)
    {
        if (p != null)
        {
            reversePrint(p.next);
            System.out.println(p.data);
        }
    }
    
}
