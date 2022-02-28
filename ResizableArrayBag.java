import java.util.*;

//Implement BagInterface using resizable array

public class ResizableArrayBag<T> implements BagInterface<T> {
	private T[] arrayBag;
	private static final int CAPACITY = 25;
	private int numOfEntries;
	
	private boolean integrityOK = false;
	private static final int MAX_CAPACITY = 10000;
	
	//Constructors
	@SuppressWarnings("unchecked")
	public ResizableArrayBag() {
		arrayBag = (T[])new Object[CAPACITY];
		numOfEntries = 0;
		integrityOK = true;
	}
	
	@SuppressWarnings("unchecked")
	public ResizableArrayBag(int capacity) {
		if (capacity <= MAX_CAPACITY) {
			T[] tempBag = (T[])new Object[capacity];
			arrayBag = tempBag;
			numOfEntries = 0;
			integrityOK = true;
		} else {
			throw new IllegalStateException("Attempt to create a bag whose" 
					+  "capacity exceeds allowed maximum.");
		}
	}
	
	public void checkIntegrity() {
		if (integrityOK == false) {
			throw new SecurityException("ArrayBag object is corrupt");
		}
	}

	public int getCurrentSize() {
		return numOfEntries;
	}

	public boolean isEmpty() {
		return numOfEntries == 0;
	}
	
	public boolean isFull() {
		if (numOfEntries == arrayBag.length) {
			return true;
		} else {
			return false;
		}
	}

	public boolean add(T newEntry) {
		checkIntegrity();
		boolean result = true;
		if (isFull()) {
			doubleCapacity();
		} else {
			arrayBag[numOfEntries] = newEntry;
			numOfEntries++;
		}
		return result;
	}
	
	public void doubleCapacity() {
		int newLength = 2*arrayBag.length;
		checkCapacity(newLength);
		arrayBag = Arrays.copyOf(arrayBag, newLength);
	}

	public void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a bag whose " +
			"capacity exeeds allowed maximum of " + MAX_CAPACITY);
		}
	}
	
	public T remove() {
		T result = arrayBag[numOfEntries];
		arrayBag[numOfEntries-1] = null;
		return result;
	}

	public boolean remove(T anEntry) {
		checkIntegrity();
		boolean removed = false;
		for (int i=0;i<numOfEntries;i++) {
			if (anEntry.equals(arrayBag[i])) {
				arrayBag[i] = arrayBag[numOfEntries-1];
				arrayBag[numOfEntries-1] = null;
				numOfEntries--;
				removed = true;
			}
		}
		return removed;
	}

	public void clear() {
		while (isEmpty() == false) {
			remove();
		}
	}

	public int getFrequencyof(T anEntry) {
		checkIntegrity();
		int counter=0;
		for (int i=0;i<numOfEntries;i++) {
			if (anEntry.equals(arrayBag[i])) {
				counter++;
			}
		}
		return counter;
	}
	
	public boolean contains(T anEntry) {
		checkIntegrity();
		boolean contains = false;
		for (int i=0;i<numOfEntries;i++) {
			if (anEntry.equals(arrayBag[i])) {
				contains = true;
			}
		}
		return contains;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numOfEntries];
		for (int i=0;i<numOfEntries;i++) {
			result[i] = arrayBag[i];
		}
		return result;
	}

	public BagInterface<T> union(BagInterface<T> otherBag) {
		ResizableArrayBag<T> unionBag = new ResizableArrayBag<T>();
		T[] bag1 = this.toArray();
		for (int i=0;i<bag1.length;i++) {
		unionBag.add(bag1[i]);
		}
		T[] bag2 = otherBag.toArray();
		for (int j=0;j<bag2.length;j++) {
		unionBag.add(bag2[j]);
		}
		return unionBag;
	}

	public BagInterface<T> intersection(BagInterface<T> otherBag) {
		ResizableArrayBag<T> bag1Copy = new ResizableArrayBag<T>();
		ResizableArrayBag<T> intersectionBag = new ResizableArrayBag<T>();
		T[] bag1 = this.toArray();
		for (int i=0;i<bag1.length;i++) {
			bag1Copy.add(bag1[i]);
		}
		T[] bag2 = otherBag.toArray();
		for (int j=0;j<bag2.length;j++) {
			if(bag1Copy.contains(bag2[j]) && !intersectionBag.contains(bag2[j])) {
				intersectionBag.add(bag2[j]);
			}	
		}
		return intersectionBag;
	}

	public BagInterface<T> difference(BagInterface<T> otherBag) {
		ResizableArrayBag<T> differenceBag = new ResizableArrayBag<T>();
		T[] bag1 = this.toArray();
		for (int i=0;i<bag1.length;i++) {
			differenceBag.add(bag1[i]);
		}
		T[] bag2 = otherBag.toArray();
		for (int j=0;j<bag2.length;j++) {
			if(differenceBag.contains(bag2[j])) {
				differenceBag.remove(bag2[j]);
			}
		}
		return differenceBag;
	}
	
}
