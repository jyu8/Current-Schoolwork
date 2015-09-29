package stuinfo;

public class StuInfo 
{
    //node class (inner class)
    private class Node
    {
        private int ID; //Student ID
        private String Lname; //Student last name
        private int age; //Student age
        private double gpa; //Student gpa
        private Node next; //Next node in list
        private Node prev; //Previous node in list
        //Node default constructor
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
    private Node head; //The first element of the list
    private Node tail; //Last element of the list
    public int size;  //Size of the list
    //Default constructor for the list
    public StuInfo()
    {
        head = null;
        tail = null;
        size = 0;
    }
    //Adds a student given the information to the list
    public void add(int ID, String Lname, int age, double gpa)
    {
        Node newdata;
        newdata = new Node(ID,Lname,age,gpa,null,null);
        //Check to see if the ID is out of bounds
        if (ID < 0 || ID >= 100000)
        {
            System.out.println("Out of ID range");
            return;
        }
        //Special case if the list is empty
        if (head == null)
        {
            head = tail = newdata;
            size++;
        }
        else //The ID is valid and list is not empty
        {
            Node tmp = head;
            //Special case if same ID is at start of list
            if (tmp.ID == newdata.ID)
            {
                System.out.println("ID already exists");
                return;
            }
            //Loop to check if ID exists int he list
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
            //Special case list of 1 element
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
            //Special case for inserting at the end of the list
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
            //Special case for inserting at the beginning of list
            else if(tmp.prev == null)
            {
                if(tmp.ID > newdata.ID)
                {
                    tmp.prev = newdata;
                    newdata.prev = null;
                    newdata.next = tmp;
                    head = newdata;
                    size++;
                    return;
                }
            }
            //Normal case
            tmp.prev.next = newdata;
            tmp.prev = newdata;
            newdata.next = tmp;
            newdata.prev= tmp.prev;
            size++;
        }
    }
    //Removes student witht the given ID
    public void remove(int RID) //Remove Student ID = R.I.D
    {
        Node removedData;
        int index = find(RID);
        if (RID < 0 || RID >= 100000) //Checks if the ID is out of bounds
        {
            System.out.println("Out of ID range or is not in the database");
            return;
        }
        //Special case list of 1
        if(head == tail)
        {
            removedData = head;
            head = tail = null;
        }
        //Special case beginning of list
        else if (index == 0)
        {
            removedData = head;
            head = head.next;
            head.prev = null;
        }
        //Special case end of list
        else if (index == size-1)
        {
            removedData = tail;
            tail = tail.prev;
            tail.next = null;
        }
        else //regular deletetion of list element
        {
            Node tmp = head;
            for (int i = 0; i < index-1; i++)
                tmp = tmp.next;
            removedData = tmp.next;
            tmp.next= tmp.next.next;
            tmp.next.prev = tmp;
        }
        size = size - 1;
        System.out.print("Removed Student: ");
        displayinfo(removedData);
    }
    //Removes all students from the list
    public void RemoveAll()
    {
        while(size != 0)
        {
            System.out.println(head.ID);
            Node tmp = get(0);
            remove(tmp.ID);
        }
        
    }
    //Takes a value and returns the index on the list
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
    //Alternate input for find
    private int find(Node data)
    {
        int i = data.ID;
        return find(i);
    }
    //Goes to the index and returns the value at that index
    public Node get(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index" + index);
        Node tmp = head;
        for (int i = 0; i < index; i++)
            tmp = tmp.next;
        return tmp;
    }
    public String PrintInfo(Node tmp)
    {
        String kappa = ("ID: "+tmp.ID+" Last name: "+tmp.Lname+" Age: " 
                +tmp.age+" GPA: "+tmp.gpa);
        return kappa;
    }
    //Displays all information given a Node
    public void displayinfo(Node tmp)
    {
        System.out.println("ID: "+tmp.ID+" Last name: "+tmp.Lname+" Age: " 
                +tmp.age+" GPA: "+tmp.gpa);
    }
    //Displays all student information
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
}