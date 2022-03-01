public class LinkedBagTest
{
     public static void main(String[] args) 
        {
            //test case 1
            BagInterface<String> bag1= new LinkedBag<>();
            String[] bagOne= {"A", "D", "B", "A", "C", "A", "D"};
            testAdd(bag1, bagOne);
           

            BagInterface<String> bag2= new LinkedBag<>();
            String[] bagTwo= {"A", "D", "B", "A", "C", "A", "D"};
            testAdd(bag2, bagTwo);
           

            System.out.println("The union in first case \n");
            BagInterface<String> everything = bag1.union(bag2);
            displayBag(everything);
            System.out.println("The intersection in first case  \n");
            BagInterface<String> commonItems = bag1.intersection(bag2);
            displayBag(commonItems);
            System.out.println("The difference in first case \n");
            BagInterface<String> leftOver1 = bag1.difference(bag2);
            displayBag(leftOver1);
            BagInterface<String> leftOver2 = bag2.difference(bag1);
            displayBag(leftOver2);

            //test case 2
            BagInterface<String> bagg1= new LinkedBag<>();
            String[] baggOne= {"a", "d", "b", "c"};
            testAdd(bagg1, baggOne);
           

            BagInterface<String> bagg2= new LinkedBag<>();
            String[] baggTwo= {"d"};
            testAdd(bagg2, baggTwo);
           

            System.out.println("The union in second case \n");
            BagInterface<String> everything1 = bagg2.union(bagg1);
            displayBag(everything1);
            System.out.println("The intersection in second case  \n");
            BagInterface<String> commonItems1 = bagg1.intersection(bagg2);
            displayBag(commonItems1);
            System.out.println("The difference in second case \n");
            BagInterface<String> leftOver1a = bagg1.difference(bagg2);
            displayBag(leftOver1a);
            BagInterface<String> leftOver2a = bagg2.difference(bagg1);
            displayBag(leftOver2a);

           
        } // end main
      
        
       private static void testAdd(BagInterface<String> aBag, String[] content)
       {
          System.out.print("Adding the following strings to the bag: ");
          for (int index = 0; index < content.length; index++)
          {
             if (aBag.add(content[index]))
                System.out.print(content[index] + " ");
             else
                System.out.print("\nUnable to add " + content[index] +
                                 " to the bag.");
          } // end for
          System.out.println();
          
          displayBag(aBag);
       } // end testAdd
       
       // Tests the method toArray while displaying the bag.
       private static void displayBag(BagInterface<String> aBag)
       {
          System.out.println("The bag contains the following string(s):");
          Object[] bagArray = aBag.toArray();
          for (int index = 0; index < bagArray.length; index++)
          {
             System.out.print(bagArray[index] + " ");
          } // end for
          
          System.out.println();
       } // end displayBag
    
    } // end LinkedBagTest
