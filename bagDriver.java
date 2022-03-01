import java.util.*;
import java.util.Scanner;

public class bagDriver 
{ 
   public static void main(String[] args) throws NullPointerException{
        Scanner keyboard = new Scanner(System.in);
 
            System.out.println("Hello here is a demo using the 3 methods in bag interface.");
            int cap = 25;
            int choice;

            //user chooses between resizable and linked
            System.out.println("Please enter 0 = ResizableArray or enter 1 = Linked bag. ");
            choice = keyboard.nextInt();

            //if user goes with resizablearray
            if(choice == 0){
               //create new bags                    
               BagInterface<String> bag1 = new ResizableArrayBag<>();
               BagInterface<String> bag2 = new ResizableArrayBag<>();
               int choice2;
                  System.out.println("Enter the contents for the 1st bag: ");
               for (int i = 0; i < cap; i++) {
                  System.out.println("Would you like to add more? YES = enter 1.  NO go to 2nd bag = enter 2: ");
                  choice2 = keyboard.nextInt();
                if (choice2 == 1) {
                    System.out.println("Please enter letter: ");
                    bag1.add(keyboard.next());
                } else if (choice2 == 2) {
                    break;
                }
            }

            System.out.println("Enter the contents of the 2nd bag: ");
               for (int i2 = 0; i2 < cap; i2++) {
                  System.out.println("Would you like to add more? YES = enter 1 NO = enter 2 to see results ");
                  choice2 = keyboard.nextInt();
               if (choice2 == 1) {
                  System.out.println("Enter a letter: ");
                  bag2.add(keyboard.next());
               } else if (choice2 == 2) {
                  break;
                }
            }

            System.out.print("Result using the three methods.");

            System.out.print("Union: ");
            System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
            
            System.out.print("Intersection: ");
            System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));

            System.out.print("Difference between the 1st bag to the 2nd: ");
            System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));

            System.out.print("Difference between the 2nd bag to the 1st: ");
            System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
         }
                //repeat but using linked bag option
                //linked bag choice
            else if(choice == 1){
               //create new bags           
               BagInterface<String> bag3 = new LinkedBag<>();
               BagInterface<String> bag4 = new LinkedBag<>();
               int choice2;
                  System.out.println("Enter the contents for the 1st bag: ");
               for (int i = 0; i < cap; i++) {
                  System.out.println("Would you like to add more? YES = enter 1.  NO go to 2nd bag = enter 2: ");
                  choice2 = keyboard.nextInt();
               if (choice2 == 1) {
                  System.out.println("Please enter letter: ");
                  bag3.add(keyboard.next());
                } else if (choice2 == 2) {
                    break;
                }
            }
                
            System.out.println("Enter the contents of the 2nd bag: ");
               for (int i2 = 0; i2 < cap; i2++) {
                  System.out.println("Would you like to add more? YES = enter 1 NO = enter 2 to see results ");
                  choice2 = keyboard.nextInt();
               if (choice2 == 1) {
                    System.out.println("Enter a letter: ");
                    bag4.add(keyboard.next());
                } else if (choice2 == 2) {
                    break;
                }
            }

            System.out.print("Result using the three methods.");

            System.out.print("Union: ");
            System.out.println(Arrays.toString(bag3.union(bag4).toArray()));

            System.out.print("Intersection: ");
            System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));

            System.out.print("Difference between the 1st bag to the 2nd: ");
            System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));

            System.out.print("Difference between the 2nd bag to the 1st: ");
            System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));

      }
   }
}
