import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        RecursiveArray array = new RecursiveArray();
        char n = 'z';
        while (n != 'h')
        {
            System.out.println("Please choose an option");
            System.out.println("A) to create a list of 20 in the 0-100 range");
            System.out.println("B) to print the list");
            System.out.println("C) to find the sum of the list");
            System.out.println("D) to test if the list contains zero");
            System.out.println("E) to print all odd numbers in the list");
            System.out.println("F) to print every other element");
            System.out.println("G) to print the elements in reverse order");
            System.out.println("H) to exit");
            n = scan.next(".").charAt(0);
            System.out.println();
            if(n == 'a')
                array.makeArray(20);
            if(n == 'b')
                array.display();
            if(n == 'c')
                System.out.println("Sum:" +array.sum());
            if(n == 'd')
                System.out.println("Zero in the list?: " + array.zeroFinder());
            if(n == 'e')
                array.oddPrinter();
            if(n == 'f')
                array.skipPrint();
            if(n == 'g')
                array.reversePrint();
            System.out.println();
        }
        scan.close();
    }
}