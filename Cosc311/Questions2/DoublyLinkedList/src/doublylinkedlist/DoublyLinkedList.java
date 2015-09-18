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
            tail = new Node(data, null, tail);
            tail.prev.next = tail;
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
        int i;
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
    public void Q1(DoublyLinkedList list)
    {
        Node tmp = list.head;
        if(tmp.next == null)
        {
            System.out.println("List too small");
        }
        else
        {
            list.remove(1);
        }
    }
    public void Q2(DoublyLinkedList list)
    {
        Node tmp = list.head;
        if(tmp.next == null)
        {
            System.out.println("List too small");
        }
        while(tmp.next != null)
        {
            tmp = tmp.next;
        }
        list.remove(tmp.prev.data);
    }
    public void Q3(DoublyLinkedList list,int num)
    {
        Node tmp = list.head;
        int myownsize = 0;
        if(tmp.next == null)
        {
            System.out.println("List too small");
        }
        while(tmp.next != null)
        {
            tmp = tmp.next;
            myownsize++;
        }
        list.add(myownsize--,num);
    }
    public void Q4(DoublyLinkedList list)
    {
        Node tmp = list.head;
        Node tmp2 = tmp.next;
        int num = ((int)tmp.data + (int)tmp2.data)/2;
        list.add(1,num);
    }
    public void Q5(DoublyLinkedList list)
    {
        Node tmp = list.head;
        int sum = 0;
        while(tmp != null)
        {
            sum += (int) tmp.data;
            tmp = tmp.next;
        }
        System.out.println("The sum is " + sum);
    }
    public void Q6(DoublyLinkedList list)
    {
        Node tmp = list.head;
        int nodecount = 0;
        while (tmp!=null)
        {
            nodecount++;
            tmp = tmp.next;
        }
        System.out.println("The number of nodes =  " + nodecount);
    }
    public void Q7(DoublyLinkedList list,int num)
    {
        Node tmp = list.head;
        int numcount = 0;
        while(tmp!=null)
        {
            if(num == (int) tmp.data)
            {
                numcount++;
            }
            tmp = tmp.next;
        }
        System.out.println("Number of times = " + numcount);
    }
    public void Q8(DoublyLinkedList list)
    {
        Node tmp = list.head;
        while (tmp != null)
        {
            System.out.println(tmp.data);
            if(tmp.next == null)
                break;
            else
                tmp= tmp.next.next;
        }
    }
    public void Q9(DoublyLinkedList list,int num1,int num2)
    {
        Object number1 = get(num1);
        Object number2 = get(num2);
        set(num1,number2);
        set(num2,number1);    
    }
    public void Q10(DoublyLinkedList list)
    {
        Node tmp = head;
        int max = (int) tmp.data;
        while(tmp !=null)
        {
            if((int) tmp.data > max)
                max = (int) tmp.data;
            tmp = tmp.next;
        }
        System.out.println("The max is = " + max);
    }
    public void Q11(DoublyLinkedList list)
    {
        int i, j, maxIndex, tmp;
        int n = list.size;
        for (i = 0; i < n-1; i++) 
        {
            maxIndex = i;
            for (j = i+1; j < n; j++)
            {
                if ((int) list.get(j) > (int) list.get(maxIndex))
                {
                    tmp = (int) list.get(maxIndex);
                    list.set(maxIndex, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
    public void Q12(DoublyLinkedList list) 
    {
        int i, j, minIndex, tmp;
        int n = list.size;
        for (i = 0; i < n - 1; i++) 
        {
            minIndex = i;
            for (j = i + 1; j < n; j++)
            {
                if ((int) list.get(j) < (int) list.get(minIndex))
                {
                    tmp = (int) list.get(minIndex);
                    list.set(minIndex, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
    public void Q13(DoublyLinkedList list1,DoublyLinkedList list2)
    {
        int j = 0;
        for(int i = 0; i<list1.size; i++)
        {
            list2.addLast(list1.get(j));
            j++;
        }
    }
    public void Q14(DoublyLinkedList list)
    {
        int j = list.size-1;
        for(int i = 0; i<list.size;i++)
        {
            System.out.println(list.get(j));
            j--;
        }
    }
}
