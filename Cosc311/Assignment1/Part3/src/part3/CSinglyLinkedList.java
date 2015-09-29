//Author: Josh Yu
package part3;
public class CSinglyLinkedList
{
    //node class(inner class)
    private class Node
    {
        private Object data;
        private Node next;
        //constructor of node
        private Node(Object data, Node next)
        {
            this.data = data;
            this.next = next;
        }  
    }
    private Node head;
    private int size;
    //constructor of list
    public CSinglyLinkedList()
    {
        head = null;
        size = 0;
    }
    //gets data from given position
    public Object get(int index)
    {
        //check bounds
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("invalid index "+ index);
        //move to position
        Node tmp = head;
        for (int i = 0; i < index; i++)
            tmp = tmp.next;

        return tmp.data;
    }
    public Object set(int index, Object data)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("invalid index "+ index);
        Node tmp = head;
        for (int i = 0; i < index; i++)
            tmp = tmp.next;
        //set new data and return old data
        Object oldData = tmp.data;
        tmp.data = data;
        return oldData;
    }
    //Adds data to the list
    public void add(int index, Object data)
    {
        //Index out of bounds error checking
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("invalid index "+ index);
        //insert at beginning special case
        if(index == 0)
            head = new Node(data, head);
        else
        {
            Node tmp = head;
            for (int i = 0; i < index-1; i++)
                tmp = tmp.next;
            tmp.next = new Node(data, tmp.next);
        }
        size++;
    }
    //Removes data from the list
    public void remove( int index)
    {
        //Special case if the point is at the end of the list
        //The new "tail" has to be pointing to the head
        if (index == size - 1)
        {
            Node tmp = head;
            Node tmp2 = head;
            for (int i = 0; i < index+1; i++)
            {
                tmp = tmp2;
                tmp2 = tmp2.next;
            }
            tmp.next = head;
        }
        //Special case if the data is at the beginning of the list
        //The next node from the "tail" needs to be the new head
        if(index == 0)
        {
           Node tmp = head;
            for (int i = 0; i < size-1; i++)
            {
                tmp = tmp.next;
                
            }
            head = head.next;
            tmp.next = head;
        }
        //general case removal
        else
        {
            Node tmp = head;
            for (int i = 0; i < index-1; i++)
                tmp = tmp.next;
            tmp.next = tmp.next.next;
        }
        size--;
    }
    //Returns the index given a data object
    public int find(Object data)
    {
        int i;
        Node tmp = head;
        for(i = 0; i < size; i++)
        {
            if(data.equals(tmp.data))
                break;
            else 
                tmp = tmp.next;
        }
        if (i == size)
            return -1;
        else 
            return i;
    }
    //Displays all of the data in the Clinked list
    public void display()
    {
        int i;
        Node tmp = head;

        for (i = 0; i < size; i++)
        {
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public int size()
    {
        return size;
    }
    //Alternate input for function that takes data instead of index)
    public boolean remove(Object data)
    {
        int i = find(data);

        if ( i == -1)
            return false;
        else
        {
            remove(i);
            return true;
        }
    }
    //Creates the singly linked list for the game
    public void CreateGroup(CSinglyLinkedList list,int n)
    {   
        //The game cannot be played alone or with nobody
        if(n <= 1)
            System.out.println("Group too small");
        else
        {
            for (int i = 1; i < n+1 ;i++)
            {
                list.add(i-1,i);
            
            }
            Node tmp = head;
            for (int i = 0; i < n-1 ;i++)
            {
                tmp = tmp.next;
            }
            tmp.next = head;
        }
    }
    //Plays the game with the inputs and the list
    public void Game(CSinglyLinkedList list,int s, int k)
    {
        Node tmp = head;
        for (int i = 0; i < s-1 ;i++) //loop to the starting int
        {
            tmp = tmp.next;
        }
        System.out.println("The starting point is at " + tmp.data);
        //removed for output printing
        //list.display();
        while(size != 1)  
        {
            for (int i = 0; i < k-1;i++) //loops to the elimination point
            {
                tmp = tmp.next;
            }
            //Removed for output printing
            //System.out.println("Eliminated "+tmp.data);
            list.remove(tmp.data);
            tmp = tmp.next;
        }
    }
}