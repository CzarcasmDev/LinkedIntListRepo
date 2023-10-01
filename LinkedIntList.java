package hw4;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class LinkedIntList {

	// helper linked list node class
	private class Node {
		private int item;
		private Node next;
		
		public Node() {	}
		public Node(int number, Node nextNode) {
			item = number;
			next = nextNode;
		}
	}

	private Node first; // first node of the list

	/**
	 * Constructs an empty list.
	 */
	public LinkedIntList() {
		first = null;
	}

	/**
	 * Constructs a list containing the elements of the specified array, in the
	 * order they appear in the array.
	 *
	 * @param data the array whose elements are to be placed into this list
	 * @throws NullPointerException if the specified array is null
	 */
	
	public LinkedIntList(int[] data) {
		first = null;
		for (int i = data.length - 1; i >= 0; i--) {
			Node newNode = new Node();
			newNode.item = data[i];
			newNode.next = first;
			first = newNode;
		}
	}
	



	/**
	 * Constructs a string representing the list. The ints in the list appear in a
	 * comma separated list contained inside square brackets.
	 * 
	 * @return a string representing the list.
	 */
	public String toString() {
		if (first == null)
			return "[]";
		String answer = "[" + first.item;
		Node ptr = first.next;
		while (ptr != null) {
			answer += ", " + ptr.item;
			ptr = ptr.next;
		}
		answer += "]";
		return answer;
	}

	/**
	 * Prints the list to StdOut as a comma separted list inside of square brackets
	 */
	public void printList() {
		StdOut.print('[');
		for (Node ptr = first; ptr != null; ptr = ptr.next) {
			StdOut.print(ptr.item + ",");
		}
		StdOut.print(']');
		StdOut.println();
	}
	
	/**
	 * Returns the first int in this list.
	 *
	 * @return the first int in this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public int getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.item;
	}


	/**
	 * Removes and returns the first int from this list.
	 *
	 * @return the first int from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public int removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		int answer = first.item;
		first = first.next;
		return answer;
	}


	/**
	 * Inserts the specified int at the beginning of this list. Shifts all ints
	 * already in the list to the right (adds one to their indices).
	 * 
	 * @param i the int to add
	 */
	public void addFirst(int i) {
		Node newFirst = new Node();
		newFirst.item = i;
		newFirst.next = first;
		first = newFirst;
	}



	/**
	 * Returns {@code true} if this list contains the specified int.
	 *
	 * @param i int whose presence in this list is to be tested
	 * @return {@code true} if this list contains the specified element
	 */
	public boolean contains(int i) { // IN CLASS Do Array loop first
		for (Node ptr = first; ptr != null; ptr = ptr.next) {
			if (ptr.item == i)
				return true;
		}
		return false;
	}

	
	/**
	 * Returns the int at the specified position in this list.
	 *
	 * @param index index of the int to return
	 * @return the int at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public int get(int index) {
		Node ptr = first;
		while (index > 0 && ptr != null) {
			ptr = ptr.next;
			index--;
		}
		if (ptr == null)
			throw new IndexOutOfBoundsException();
		else
			return ptr.item;
	}

	/**
	 * Replaces the int at the specified position in this list with the specified
	 * int.
	 *
	 * @param index index of the element to replace
	 * @param i     int to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public int set(int index, int i) {
		Node ptr = first;
		while (index > 0 && ptr != null) {
			ptr = ptr.next;
			index--;
		}
		if (ptr == null)
			throw new IndexOutOfBoundsException();
		int answer = ptr.item;
		ptr.item = i;
		return answer;
	}

	/**
	 * Inserts the specified int at the specified position in this list. Shifts the
	 * int currently at that position (if any) and any subsequent ints to the right
	 * (adds one to their indices).
	 *
	 * @param index index at which the specified int is to be inserted
	 * @param i     int to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public void add(int index, int i) { 
		Node previous = null;
		Node position = first;
		while (index > 0 && position != null) {
			previous = position;
			position = position.next;
			index--;
		}
		if (index > 0)
			throw new IndexOutOfBoundsException();
		Node newNode = new Node();
		newNode.item = i;
		newNode.next = position;
		if (previous == null)
			first = newNode;
		else
			previous.next = newNode;
	}
	
	/**
	 * Removes the first occurrence of the specified int in this list (when
	 * traversing the list from head to tail). If the list does not contain the int,
	 * it is unchanged.
	 *
	 * @param i int to be removed from this list, if present
	 * @return {@code true} if the list contained the specified int
	 */
	public boolean removeFirstOccurrence(int i) {
		if (first == null)
			return false;
		if (first.item == i) {
			first = first.next;
			return true;
		}
		Node ptr = first;
		while (ptr.next != null && ptr.next.item != i)
			ptr = ptr.next;
		if (ptr.next == null)
			return false;
		ptr.next = ptr.next.next;
		return true;
	}


	/**
	 * Returns the index of the first occurrence of the specified int in this list,
	 * or -1 if this list does not contain the int.
	 *
	 * @param i int to search for
	 * @return the index of the first occurrence of the specified int in this list,
	 *         or -1 if this list does not contain the int
	 */
	public int indexOf(int i) { // TODO
		int counter = 0;
		for (Node currentPos = first; currentPos != null; currentPos = currentPos.next) {
			if (currentPos.item == i) {
				return counter;
			}
			counter++;
		}
		return -1;
	}




	/**
	 * Removes the last occurrence of the specified int in this list (when
	 * traversing the list from head to tail). If the list does not contain the int,
	 * it is unchanged.
	 *
	 * @param i int to be removed from this list, if present
	 * @return {@code true} if the list contained the specified int
	 */
	public boolean removeLastOccurrence(int i) { // TODO
		for (Node currentPos = first; currentPos != null; currentPos = currentPos.next) {
			if (currentPos.item == i) {
				this.removeFirstOccurrence(i);
				for (Node currentPos2 = first; currentPos2 != null; currentPos2 = currentPos2.next) {
					if (currentPos2.item == i) {
						this.removeLastOccurrence(i);   
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Computes the sum of all the ints in the list.
	 * 
	 * @return the sum of all the ints in the list
	 */
	public int sum() { // TODO
		int counter = 0;
		for (Node currentPos = first; currentPos != null; currentPos = currentPos.next) {
			counter += currentPos.item;
		}
		return counter;
	}



	/**
	 * Determines if the even numbers in the list are strictly increasing.
	 * 
	 * @return {@code true} if every even number in the list is greater than
	 * the previous even number in list (when there is a previous even number). 
	 */
	public boolean increasingEvens() {  // TODO
		int lastFoundEven = 0;
		for (Node currentPos = first; currentPos != null; currentPos = currentPos.next) {
			if (currentPos.item % 2 == 0) {
				if (lastFoundEven > currentPos.item) {
					return false;
				}
				lastFoundEven = currentPos.item;
			}
		}
		return true;
	}

	/**
	 * Constructs a new int list where each entry in the new list is the sum of the
	 * corresponding entries in this list and the argument list.
	 * 
	 * @arg otherList the other list to be added to this list
	 * @return a new list where each entry in the new list is the sum of the
	 *         corresponding entries in this list and the argument list
	 * @throws IllegalArgumentException if this list and the other list have have
	 *                                  different lengths
	 */
	public LinkedIntList listAddition(LinkedIntList otherList) {  // TODO
		int lenCounter = 0;
		int SecondlenCounter = 0;
		for (Node currentPos = first; currentPos != null; currentPos = currentPos.next) {
			lenCounter++;
		}
		for (Node currentPos = otherList.first; currentPos != null; currentPos = currentPos.next) {
			SecondlenCounter++;
		}
		if (lenCounter != SecondlenCounter) {
			throw new IllegalArgumentException("Lists have different lengths.");
		}
		LinkedIntList CombinedList = new LinkedIntList();
		LinkedIntList modifiedList = new LinkedIntList();
		LinkedIntList modifiedList2 = new LinkedIntList();
		for (Node currentPos = otherList.first; currentPos != null; currentPos = currentPos.next) {
			modifiedList.addFirst(currentPos.item);
		}
		for (Node currentPos = first; currentPos != null; currentPos = currentPos.next) {  //idk how but unless i made new lists for each of the lists it was reversing one of them. weird bill gates voodoo magic
			modifiedList2.addFirst(currentPos.item);
		}
		for (Node currentPos = first; currentPos != null; currentPos = currentPos.next) {
			int add1 = modifiedList2.removeFirst();
			int add2 = modifiedList.removeFirst();
			Node newAdd = new Node();
			newAdd.item = add1 + add2;
			CombinedList.addFirst(newAdd.item);
		}
		return CombinedList;
	}
	
	/* A small main to get started testing */
	public static void main(String[] args) {

	}
}
