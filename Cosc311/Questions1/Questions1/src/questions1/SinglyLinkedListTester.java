package questions1;

/**
 *
 * @author Josh
 */
public class SinglyLinkedListTester 
{
    public static void main(String[] args)
    {
    SinglyLinkedList list1 = new SinglyLinkedList();
    SinglyLinkedList list3 = new SinglyLinkedList();
    list1.addFirst(100);
    list1.addFirst(72);
    list1.addFirst(100);
    list1.addFirst(200);
    list1.addFirst(100);
    list1.add(1, 50);
    list1.display();
    System.out.println();
//    list1.Q1(list1);
//    list1.Q2(list1);
//    list1.Q3(list1,999);
//    list1.Q4(list1);
//    list1.Q5(list1);
//    list1.Q6(list1);
//    list1.Q7(list1,100);
//    list1.Q8(list1);
//    list1.Q9(list1,2,4);
//    list1.Q10(list1);
//    list1.Q11(list1);
    list1.Q12(list1);
//    list1.Q13(list1, list3);
//    list1.Q14(list1);
    System.out.println();
    list1.display();
//    list3.display();
    System.out.println();
    
    SinglyLinkedList list2 = new SinglyLinkedList();
    list2.addFirst("Bob");
    list2.addFirst("Kappa");
    list2.addFirst("PogChamp");
    list2.addFirst("BibleThump");
    list2.display();
    
//    list2.Q2(list2);
    list2.display();
    
//    int i = (int) list1.get(0);
//    System.out.println(i);
    }
}
