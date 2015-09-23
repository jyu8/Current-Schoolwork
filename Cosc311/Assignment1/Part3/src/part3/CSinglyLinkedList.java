/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part3;
import java.util.Scanner;
/**
 *
 * @author Josh
 */
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
    public void add(int index, Object data)
    {
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
    public void remove( int index)
    {
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
        
        else
        {
            Node tmp = head;
            for (int i = 0; i < index-1; i++)
                tmp = tmp.next;
            tmp.next = tmp.next.next;
        }
        size--;
    }
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
    public void CreateGroup(CSinglyLinkedList list,int n)
    {   
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
    public void Game(CSinglyLinkedList list,int s, int k)
    {
        Scanner keyboard = new Scanner(System.in);
        Node remove;
        Node tmp = head;
        for (int i = 0; i < s-1 ;i++)
        {
            tmp = tmp.next;
        }
        System.out.println("The starting point is at " + tmp.data);
        //1st case is special becuase it exlcudes the starting point
        list.display();
        for (int i = 0; i < k-1;i++)
            {
                tmp = tmp.next;
            }
            System.out.println("Eliminated "+tmp.data);
            list.remove(tmp.data);
            tmp = tmp.next;
        while(size != 1)  
        {
            for (int i = 0; i < k-1;i++)
            {
                tmp = tmp.next;
            }
            System.out.println("Eliminated "+tmp.data);
            list.remove(tmp.data);
            tmp = tmp.next;
        }
    }
}