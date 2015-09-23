package stuinfo;

public class StuInfo 
{
    //node class (inner class)
    private class Node
    {
        private int ID;
        private String Lname;
        private int age;
        private double gpa;
        private Node next;
        private Node prev;
        private Node(int ID,String Lname,int age, double gpa,
                Node next,Node prev)
        {
            this.next = next;
            this.prev = prev;
            this.ID = ID;
            this.Lname = Lname;
            this.age = age;
            this.gpa = gpa;
        }
    }
    private Node head;
    private Node tail;
    private int size; 
    public StuInfo()
    {
        head = null;
        tail = null;
        size = 0;
    }
    public void add(int ID, String Lname, int age, double gpa)
    {
        
        Node newdata;
        newdata = new Node(ID,Lname,age,gpa,null,null);
        if (ID < 0 || ID >= 100000)
        {
            System.out.println("Out of ID range");
            return;
        }     
        if (head == null)
        {
            head = tail = newdata;
            size++;
        }
        else
        {
            Node tmp = head;
            if (tmp.ID == newdata.ID)
            {
                System.out.println("ID already exists");
                return;
            }    
            while(tmp.ID < newdata.ID)
            {
                //if last element of a list is reached
                if(tmp.next == null)
                    break;
                tmp = tmp.next;
                if (tmp.ID == newdata.ID)
                    throw new IndexOutOfBoundsException("ID " +ID+
                            " already exists");
            }
            //list of 1
            if(tmp.next == null && tmp.prev == null)
            {
                if(tmp.ID < newdata.ID)
                {
                    tmp.next = newdata;
                    newdata.prev = tmp;
                    newdata.next = null;
                    tail = newdata;
                }
                else
                {
                    newdata.next = tmp;
                    tmp.prev = newdata;
                    tmp.next = null;
                    head = newdata;
                }
                size++;
                return;
            }
            else if(tmp.next == null)
            {
                if(tmp.ID < newdata.ID)
                {
                   tmp.next = newdata;
                    newdata.prev = tmp;
                    newdata.next = null;
                    tail = newdata;
                    size++;
                    return;
                }
            }
            else if(tmp.prev == null)
            {
                if(tmp.ID > newdata.ID)
                {
                    tmp.prev = newdata;
                    newdata.prev = null;
                    newdata.next = tmp;
                    head = newdata;
                }
            }
            tmp.prev.next = newdata;
            tmp.prev = newdata;
            newdata.next = tmp;
            newdata.prev= tmp.prev;
            size++;
        }
    }
    public void display()
    {
        int i;
        Node tmp = head;
        for (i = 0; i < size; i++)
        {
            displayinfo(tmp);
            tmp = tmp.next;
        }
    }
    public int find(int data)
    {
        int i;
        Node tmp = head;
        for ( i = 0; i < size; i++)
        {
            if (data == (tmp.ID))
            {
                break;
            }  
            else
                tmp = tmp.next;
        }
        if (i == size)
            return -1;
        else 
            return i;
    }
    public Node get(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index" + index);
        Node tmp = head;
        for (int i = 0; i < index; i++)
            tmp = tmp.next;
        return tmp;
    }
    public void displayinfo(Node tmp)
    {
        System.out.println("ID: "+tmp.ID+" Last name: "+tmp.Lname+" Age: " 
                +tmp.age+" GPA: "+tmp.gpa);
    }
    public void remove(int RID)
    {
        Node removedData;
        int z = find(RID);
        if (z < 0 || z >= 100000)
        {
            System.out.println("Out of ID range or is not in the database");
            return;
        }     
        if(head == tail)
        {
            removedData = head;
            head = tail = null;
        }
        else if (z == 0)
        {
            removedData = head;
            head = head.next;
            head.prev = null;
        }
        else if (z == size-1)
        {
            removedData = tail;
            tail = tail.prev;
            tail.next = null;
        }
        else
        {
            Node tmp = head;
            for (int i = 0; i < z-1; i++)
                tmp = tmp.next;
            removedData = tmp.next;
            tmp.next= tmp.next.next;
            tmp.next.prev = tmp;
        }
        size = size - 1;
        System.out.print("Removed Student: ");
        displayinfo(removedData);
    }
}