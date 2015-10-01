/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questions3;

/**
 *
 * @author Josh
 */
public class ArrayList 
{
    private Object[] array;
    private int capacity;
    int size;
    private final int INITIAL_CAPACITY = 10;
    public ArrayList()
    {
        array = new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
    }
    public Object get(int index)
    {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index" + index);
        return array[index];
    }
    public Object set(int index, Object data)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index" + index);
        Object oldData = array[index];
        array[index] = data;
        return oldData;
    }
    public void add(int index, Object data)
    {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Invalid index " + index);
        if(size == capacity)
            reallocate();
        for(int i =  size; i>index;i--)
            array[i] = array[i - 1];
        array[index] = data;
        size = size + 1;
    }
    public Object remove(int index)
    {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index "+ index);
        Object removedData = array[index];    
        for(int i = index+1; i < size; i ++)
            array[i-1] = array[i];
        size = size-1;
        return removedData;
    }
    public int find(Object data)
    {
        int i;
        for(i = 0; i < size; i ++)
            if(data.equals(array[i]))
                break;
        if(i == size)
            return -1;
        else return i;
    }
    public void display()
    {
        int i;
        for(i = 0; i < size; i++)
            System.out.println(array[i]);
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
        if (i == -1)
            return false;
        else
        {
            remove(i);
            return true;
        }
    }
    private void reallocate()
    {               
        capacity = 2*capacity;
        Object[] newArray = new Object[capacity];
        for(int i = 0; i < size; i++)
            newArray[i] = array[i];
        array = newArray;
    }
    public void Q1()
    {
        for (int i = 2; i < size; i++)
            array[i-1] = array[i];
        size--;
    }
    public void Q2()
    {
        size--;
    }
    public void Q3(Object data)
    {
        Object temp = array[size-1]; 
        array[size-1] = data;
        array[size] = temp;
        size++;
    }
    public void Q4()
    {
        int num1 = (int)array[0];
        int num2 = (int)array[1];
        int value = (num1+num2)/2;
        for(int i = 1; i<size; i++)
            array[i-1] = array[i];
        array[1] = value;
        size++;
    }
    public void Q5(Object data)
    {
        int count = 0;
        for(int i = 0; i < size; i++)
        {
            if(data == array[i])
                count++;
        }
        System.out.println("Times: "+ count);
    }
    public void Q6()
    {
        for(int i =0; i <size; i+=2)
        {
            System.out.println(array[i]);
        }
    }
    public void Q7(int place1, int place2)
    {
        Object temp1 = array[place1];
        Object temp2 = array[place2];
        array[place1] = temp2;
        array[place2] = temp1;
    }
    public void Q8()
    {
        int max = (int) array[0];
        for(int i = 0; i <size; i++)
        {
            if(max < (int)array[i])
            {
                max = (int)array[i];
            }
        }
        System.out.println("The max is: " + max);
    }
    public void Q9(ArrayList list)
    {
        
    }
    public void Q10()
    {
        System.out.println("hey" + array[size+1]);
    }
}

