package doublylinkedlist;

public class DoublyLinkedList 
{
    //node class (inner class)
    private class Node
    {
        private Object data;
        private Node next;
        private Node prev;
        
        private Node(Object data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    public Object get(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index" + index);
        Node tmp = head;
        for (int i = 0; i < index; i++)
            tmp = tmp.next;
        return tmp.data;
    }
    public Object set(int index, Object data)
    {
        if(index < 0 || index >=size)
            throw new IndexOutOfBoundsException("Invalid index" + index);
        Node tmp = head; 
        for (int i = 0; i < index; i++)
            tmp = tmp.next;
        Object oldData = tmp.data;
        tmp.data = data;
        return oldData;
    }
    public void add(int index, Object data)
    {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Invalid index" + index);
        if (head == null)
            head = tail = new Node(data,null,null);
        else if (index == 0)
        {
            head = new Node(data, head, null);
            head.next.prev = head;
        }
        else if (index == size)
        {
            tail = new Node(data, null tail);
        }
        else
        {
            Node tmp = head;
            for(int i = 0; i < index-1; i++)
                tmp = tmp.next;
            tmp.next = new Node(data, tmp.next,tmp);
            tmp.next.next.prev = tmp.next;
        }
        size = size + 1;
    }
    public Object remove(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index" + index);
        Object removedData;
        if(head == tail)
        {
            removedData = head.data;
            head = tail = null;
        }
        else if (index == 0)
        {
            removedData = head.data;
            head = head.next;
            head.prev = null;
        }
        else if (index == size-1)
        {
            removedData = tail.data;
            tail = tail.prev;
            tail.next = null;
        }
        else
        {
            Node tmp = head;
            for (int i = 0; i < index-1; i++)
                tmp = tmp.next;
            removedData = tmp.next.data;
            tmp.next= tmp.next.next;
            tmp.next.prev = tmp;
        }
        size = size - 1;
        return removedData;
    }
    public int find(Object data)
    {
        int i = 0;
        Node tmp = head;
        for ( i = 0; i < size; i++)
        {
            if (data.equals(tmp.data))
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
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
    public int size()
    {
        return size;
    }
    public void addFirst(Object data)
    {
        add(0,data);
    }
    public Object removeFirst()
    {
        Object data = remove(0);
        return data;
    }
    public void addLast(Object data)
    {
        add(size,data);
    }
    public Object removeLast()
    {
        Object data = remove(size - 1);
        return data;
    }
    public boolean remove(Object data)
    {
        int i = find(data);
        if(i == -1)
            return false;
        else
        {
            remove(i);
            return true;
        }
    }
}
