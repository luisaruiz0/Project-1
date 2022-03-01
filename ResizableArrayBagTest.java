import java.util.*;

//Test ResizableArray implementation of BagInterface
public class ArrayBagTest {

	public static void main(String[] args) {
		//Test case
		ResizableArrayBag<String> bag1 = new ResizableArrayBag<String>();
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>();

		bag1.add("a");
		bag1.add("b");
		bag1.add("c");
	
		bag2.add("a");
		bag2.add("a");
		bag2.add("e");
		bag2.add("d");

		System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
		System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
		System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
		
		//Test case
		ResizableArrayBag<String> bag3 = new ResizableArrayBag<String>();
		ResizableArrayBag<String> bag4 = new ResizableArrayBag<String>();

		bag3.add("a");
		bag3.add("b");
		bag3.add("c");
	
		bag4.add("A");
		bag4.add("B");
		bag4.add("c");
		bag4.add("d");

		System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
		System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
		System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
	}
	

}
