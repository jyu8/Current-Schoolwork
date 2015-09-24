package assignment1part1;

public class BooksCustomers
{
    private class CustomerNode
    {
        private String name;
        private int copies;
        private CustomerNode next;
        
        private CustomerNode(String name, int copies)
        {
            this.name = name;
            this.copies = copies;
            this.next = next;
        }
    }
    private class BookNode
    {
        private String title;
        private double price;
        private int sold;
        private CustomerNode list;
        private BookNode next;
    
        private BookNode(String title, double price, int sold,
        CustomerNode list, BookNode next)
        {    
            this.title = title;
            this.price = price;
            this.sold = sold;
            this.list = list;
            this.next = next;
        }
    }
    private BookNode head;
    public BooksCustomers()
    {
        head = null;
    }
    public void addBook(String title, double price)
    {
        boolean found = false;
        for (BookNode temp = head; temp != null; temp = temp.next)
        {
            if (temp.title.equals(title))
            {
                found = true;
                break;
            }
        }
        if (!found)
        {
            if(head == null)
                head = new BookNode(title,price, 0 , null, head);
            else
            {
                BookNode temp = head;
                head = new BookNode(title,price, 0 , null, temp);
            }     
        }    
        else 
            System.out.println("Title already exists in the book list");
    }
    public void orderBook(String title, String name, int copies)
    {
        CustomerNode newCN = new CustomerNode(name,copies);
        boolean found = false;
        BookNode temp = head;
        if (temp.title.equals(title))
            found = true;
        else
        {
            while(temp.next != null)
            {
                if (temp.title.equals(title))
                {
                    found = true;
                    break;
                }
                temp = temp.next;
            }
        }
        if(temp.title.equals(title))
            found = true;
        if (!found)
            System.out.println("Book is not in the book list");
        else
        {
            CustomerNode CNtemp = temp.list;
            if(temp.list == null)
            {
                temp.list = newCN;
            }
            else
            {
                while(CNtemp.next !=null)
                {
                    CNtemp = CNtemp.next;
                }
                CNtemp.next = newCN;
                newCN.next = null;
            }
        }
    }
    public void sellBook(String title)
    {
        boolean found = false;
        BookNode temp = head;
        if (temp.title.equals(title))
                found = true;
        else
        {
            while(temp.next != null)
            {
                if (temp.title.equals(title))
                {
                    found = true;
                    break;
                }
                temp = temp.next;
            }
        }
        if(temp.title.equals(title))
            found = true;
        if (!found)
            System.out.println("Book is not in the book list");
        else 
        {
            boolean found2 = false;
            if(temp.list == null)
            {
                System.out.println("No customers in this list");
                return;
            }
            else
            {
                String buyer = temp.list.name;
                int sold = temp.list.copies;
                if (temp.list.next == null)
                {
                    temp.list = null;
                }
                else
                {
                    temp.list = temp.list.next;
                }
                temp.sold += sold;
                System.out.println(sold+" Copies sold to "+ buyer);
            }
        }
    }
    public void cancelBook(String title, String name)
    {
        boolean found = false;
        BookNode temp = head;
        if (temp.title.equals(title))
                found = true;
        while(temp.next != null)
        {
            if (temp.title.equals(title))
            {
                found = true;
                break;
            }
            temp = temp.next;
        }
        if(temp.title.equals(title))
            found = true;
        if (!found)
            System.out.println("Book is not in the list");
        else 
        {
            boolean found2 = false;
            if(temp.list == null)
            {
                System.out.println("No customers in this list");
            }
            else
            {
                CustomerNode CNtemp = temp.list;
                while(CNtemp != null)
                {
                    if (CNtemp.name.equals(name))
                    {
                        found2 = true;
                        break;
                    }
                    CNtemp = CNtemp.next;
                }
                if (!found2)
                    System.out.println("Customer is not in the list");
                else
                {
                    CustomerNode CNtemp2 = temp.list;
                    if(CNtemp2 == null)
                    {
                        temp.list.next = null;
                    }
                    else if(CNtemp2 == CNtemp)
                    {
                        temp.list = temp.list.next;
                    }
                    else
                    {
                        while(CNtemp2.next != CNtemp)
                        {
                            CNtemp2 = CNtemp2.next;
                        }
                        CNtemp2.next = CNtemp.next;
                    }
                }
            }
            
        }
    }
    public void bookInfo(String title)
    {
        boolean found = false;
        BookNode temp = head;
        while(temp != null)
        {
            if (temp.title.equals(title))
            {
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Book is not in the list");
        else 
        {
            System.out.println("Book title: " + temp.title);
            System.out.println("Book price: " + temp.price);
            System.out.println("Copies sold: " + temp.sold);
            System.out.println("Customer waiting list:");
            CustomerNode CNtemp = temp.list;
            if(CNtemp== null)
            {
                System.out.println("No customers have ordered this book");
            }
            while (CNtemp != null)
            {
                System.out.println("Customer " + CNtemp.name + " is buying "
                + CNtemp.copies + " copies");
                CNtemp = CNtemp.next;
            }
        }    
    }
    public void allInfo()
    {
        BookNode temp = head;
        while(temp != null)
        {
            bookInfo(temp.title);
            temp = temp.next;
        }
    }
}


