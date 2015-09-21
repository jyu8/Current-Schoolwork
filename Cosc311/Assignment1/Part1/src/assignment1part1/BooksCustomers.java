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
            head = new BookNode(title,price, 0 , null, head);
        else 
            System.out.println("Title already exists in the book list");
    }
    //public void orderBook(String title, String name, int copies)
    //public void sellBook(String title)
    //public void cancelBook(String title, String name)
    //public void bookInfo(String title)
    //public void allInfo()
}


