package questions1;

public class SinglyLinkedList
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
    public SinglyLinkedList()
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
    public Object remove(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("invalid index "+ index);
        Object removedData;
        if(index == 0)
        {
            removedData = head.data;
            head = head.next;
        }
        else
        {
            Node tmp = head;
            for (int i = 0; i < index; i++)
                tmp = tmp.next;
            removedData = tmp.next.data;
            tmp.next = tmp.next.next;
        }
        size--;
        return removedData;
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
        Object data = remove(size-1);
        return data;
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
    public void Q1(SinglyLinkedList list)
    {
        Node tmp = head;
        if(tmp.next == null)
        {
             System.out.println("List too small");
        }
        else
        {
            list.remove(1);
        }
    }
    public void Q2(SinglyLinkedList list)
    {
        int myownsize = 0;
        Node tmp1 = head;
        if(tmp1.next == null)
        {
             System.out.println("List too small");
        }
        while(tmp1 != null)
        {
            tmp1 = tmp1.next;
            myownsize++;
        }
        myownsize-=2;
        list.remove(myownsize);
    }
    public void Q3(SinglyLinkedList list,int i)
    {
        int myownsize = 0;
        Node tmp1 = head;
        if(tmp1.next == null)
        {
             System.out.println("List too small");
        }
        myownsize++;
        while(tmp1.next != null)
        {
            tmp1 = tmp1.next;
            myownsize++;
        }
        myownsize--;
        list.add(myownsize, i);
    }
    public void Q4(SinglyLinkedList list)
    {
        Node tmp1 = head;
        if(tmp1.next == null)
        {
             System.out.println("List too small");
        }
        Node tmp2 = tmp1;
        tmp1 = tmp1.next;
        int num1 = (int) tmp1.data;
        int num2 = (int) tmp2.data;
        int sum = (num1+num2)/2;
        list.add(1, sum);
    }
    public void Q5(SinglyLinkedList list)
    {
        Node tmp1 = head;
        int sum = 0;
        while(tmp1.next != null)
        {
            sum += (int) tmp1.data;
            tmp1 = tmp1.next;
        }
        sum += (int) tmp1.data;
        System.out.println("The sum is " +sum);
    }
    public void Q6(SinglyLinkedList list)
    {
        Node tmp1 = head;
        int count = 0;
        while(tmp1 != null)
        {
            count ++;
            tmp1 = tmp1.next;
        }   
        System.out.println("Number of nodes = " +count);
    }
    public void Q7(SinglyLinkedList list,int num)
    {
        Node tmp1 = head;
        int count = 0;
        while(tmp1.next != null)
        {
            if((int) tmp1.data == num)
            {
                count ++;
            }    
            tmp1 = tmp1.next;
        }
        if((int) tmp1.data == num)
        {
                count ++;
        } 
        System.out.println(count);
    }
    public void Q8(SinglyLinkedList list)
    {
        Node tmp1 = head;
        while(tmp1.next != null)
        {
            System.out.println((int)tmp1.data);
            tmp1 = tmp1.next;
            if(tmp1.next == null)
                break;
            else
                tmp1 = tmp1.next;
        }
    }
    public void Q9(SinglyLinkedList list,int num1,int num2)
    {
        Object number1 = list.get(num1);
        Object number2 = list.get(num2);
        list.set(num1,number2);
        list.set(num2,number1);
    }
    public void Q10(SinglyLinkedList list)
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
    public void Q11(SinglyLinkedList list)
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
    public void Q12(SinglyLinkedList list) 
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
    public void Q13(SinglyLinkedList list1,SinglyLinkedList list2)
    {
        int j = 0;
        for(int i = 0; i<list1.size; i++)
        {
            list2.addLast(list1.get(j));
            j++;
        }
    }
    public void Q14(SinglyLinkedList list)
    {
        int j = list.size-1;
        for(int i = 0; i<list.size;i++)
        {
            System.out.println(list.get(j));
            j--;
        }
    }
}