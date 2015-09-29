package assignment1part1;

public class BooksCustomers
{
    //Customer node is a vertical list that stems from Booknode.list
    private class CustomerNode
    {
        private String name; //Customer last name
        private int copies; //Number of copies customer orders
        private CustomerNode next; //Next in the list 
        //constructor for Customer node
        private CustomerNode(String name, int copies)
        {
            this.name = name;
            this.copies = copies;
            this.next = next;
        }
    }
    private class BookNode
    {
        private String title; //Title of the book
        private double price; //Price of the book
        private int sold; //Number of copies sold
        private CustomerNode list; //The head of the CustomerNode list
        private BookNode next; //Next BookNode in the list
        //constructor for book node
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
    //constructor for BooksCustomer
    public BooksCustomers()
    {
        head = null;
    }
    //Given a book title and the price, add a book to the database
    public void addBook(String title, double price)
    {
        boolean found = false;
        //Searches the whole list to verify if the title is present
        for (BookNode temp = head; temp != null; temp = temp.next)
        {
            if (temp.title.equals(title)) //if title is found
            {
                found = true;
                break;
            }
        }
        if (!found)
        {
            //Special case of the list being empty
            if(head == null)
                //The next of the single case points to null
                head = new BookNode(title,price, 0 , null, null);
            else
            {
                BookNode temp = head;
                //Compared to above, the new head points to the previous head
                head = new BookNode(title,price, 0 , null, temp);
            }     
        }
        //If found, book already exists in this list
        else 
            System.out.println("Title already exists in the book list");
    }
    //Places an order for the book
    public void orderBook(String title, String name, int copies)
    {
        //Create Customer node newCN with the order data
        CustomerNode newCN = new CustomerNode(name,copies);
        boolean found = false;
        //The difference between the list search fuction for add is that
        //this one has the variable decared outside of the loop so that the
        //position can be used in other parts
        BookNode temp = head;
        //Special case if the book is at the beginning of the list
        if (temp.title.equals(title))
            found = true;
        else
        {
            while(temp.next != null) //Searches the list for the book title
            {
                if (temp.title.equals(title))
                {
                    found = true;
                    //Once the book is found,  break out
                    break;
                }
                temp = temp.next;
            }
        }
        //Special case if the book is at the end of the list
        if(temp.title.equals(title))
            found = true;
        //If book is not found print error
        if (!found)
            System.out.println("Book is not in the book list");
        else //Book was found in the list
        {
            //Places the customer order at the end of the list
            CustomerNode CNtemp = temp.list;
            //Special case if the Customer Node list is empty
            if(temp.list == null)
            {
                temp.list = newCN; //At the end of the list, next is null
            }
            else 
            {
                //Finds the last order on the CustomerList and creates
                //places the order at the end
                while(CNtemp.next !=null)
                {
                    CNtemp = CNtemp.next;
                }
                CNtemp.next = newCN;
                newCN.next = null;
            }
        }
    }
    //Sells book with the given title
    public void sellBook(String title)
    {
        boolean found = false;
        BookNode temp = head;
        //Special case if title is at the beginning of the list
        if (temp.title.equals(title))
                found = true;
        else
        {
            //Searches the list for the given title
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
        //Special case if the title is at the end of the list
        if(temp.title.equals(title))
            found = true;
        //If the book was not found in the list
        if (!found)
            System.out.println("Book is not in the book list");
        else //Book was found in the list
        {
            boolean found2 = false;
            //Checks to see if there are any customers in the list
            if(temp.list == null)
            {
                System.out.println("No customers in this list");
                return;
            }
            else
            {
                //Variables for printing out
                String buyer = temp.list.name;
                int sold = temp.list.copies;
                //Special case if there is only one customer in the list
                if (temp.list.next == null)
                {
                    temp.list = null;
                }
                else //remove the customer from the list
                {
                    temp.list = temp.list.next;
                }
                temp.sold += sold; //Change sold by the number of copies
                System.out.println(sold+" Copies sold to "+ buyer);
            }
        }
    }
    //Cancels a book order given a title and the name canceling the book
    public void cancelBook(String title, String name)
    {
        boolean found = false;
        BookNode temp = head;
        //Special case if the title is at the head of the list
        if (temp.title.equals(title))
                found = true;
        while(temp.next != null) //Searches the list for the book title
        {
            if (temp.title.equals(title))
            {
                found = true;
                break; //Break out once the book is found
            }
            temp = temp.next;
        }
        //Special case if the title is at the end of the list
        if(temp.title.equals(title))
            found = true;
        //If book is not in the list
        if (!found)
            System.out.println("Book is not in the list");
        else //Book is found in the list 
        {
            boolean found2 = false;
            if(temp.list == null) //Case of no customers in the list
            {
                System.out.println("No customers in this list");
            }
            else //If there are customers in the list
            {
                CustomerNode CNtemp = temp.list;
                while(CNtemp != null) //Search the list for customer name
                {
                    if (CNtemp.name.equals(name))
                    {
                        found2 = true;
                        break;
                    }
                    CNtemp = CNtemp.next;
                }
                if (!found2) //No customer in the list
                    System.out.println("Customer is not in the list");
                else //Once the customer is found
                {
                    CustomerNode CNtemp2 = temp.list;
                    //Special case for customer at beginning of list
                    if(CNtemp2 == CNtemp)
                    {
                        System.out.println("Canceled order for "+temp.list.name
                        +" for " + temp.list.copies+" copies");
                        temp.list = temp.list.next;
                    }
                    else //Remove the book as normal
                    {
                        while(CNtemp2.next != CNtemp)
                        {
                            CNtemp2 = CNtemp2.next;
                        }
                        System.out.println("Canceled order for "+CNtemp.name
                        +" for " + CNtemp.copies+" copies");
                        CNtemp2.next = CNtemp.next;
                    }
                }
            }
            
        }
    }
    //Print out information on a book and its customers
    public void bookInfo(String title)
    {
        boolean found = false;
        BookNode temp = head;
        //Search the list for the book title
        while(temp != null)
        {
            if (temp.title.equals(title))
            {
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (!found)   //If book isn't found in the list
            System.out.println("Book is not in the list");
        else //Once book is found, print out the information
        {
            System.out.println("Book title: " + temp.title);
            System.out.println("Book price: " + temp.price);
            System.out.println("Copies sold: " + temp.sold);
            System.out.println("Customer waiting list:");
            CustomerNode CNtemp = temp.list;
            if(CNtemp== null) //If there are no customers in the list
            {
                System.out.println("No customers have ordered this book");
            }
            while (CNtemp != null) //Print out each customer
            {
                System.out.println("Customer " + CNtemp.name + " is buying "
                + CNtemp.copies + " copies");
                CNtemp = CNtemp.next;
            }
        }    
    }
     //Print out information on all books and their customers
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


