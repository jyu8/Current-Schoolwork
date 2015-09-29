//Author: Josh Yu
package part3;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        CSinglyLinkedList list = new CSinglyLinkedList();
        System.out.print("Enter a group size. n = ");
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        list.CreateGroup(list,n);
        System.out.print("Enter the starting person. s = ");
        int s = S.nextInt();
        System.out.print("Enter how many people are skipped. k = ");
        int k = S.nextInt();
        //Get the inputs and start the game
        list.Game(list,s,k);
        System.out.println(list.get(0)+ " is your loser");
    }
}
