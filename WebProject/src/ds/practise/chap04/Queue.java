package ds.practise.chap04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{

	private int N;
	private Node first;
	private Node last;

	// helper linked list class
	private class Node {
		private Item item;
		private Node next;
	}

	/**
	 * Create an empty queue.
	 */
	public Queue() {
		first = null;
		last = null;
	}

	/**
	 * Is the queue empty?
	 */
	public boolean isEmpty() {
		return (first == null);
	}

	/**
	 * Return the number of items in the queue.
	 */
	public int size() {
		return N;
	}

	/**
	 * Return the number of items in the queue.
	 */
	public int length() {
		return N;
	}

	/**
	 * Return the item least recently added to the queue. Throw an exception if
	 * the queue is empty.
	 */
	public Item peek() {
		if (isEmpty()) {
			throw new RuntimeException("Queue Underflow");
		}
		return first.item;
	}

	/**
	 * Add the item to the queue.
	 */
	public void enqueue(Item item) {
		Node x = new Node();
		x.item = item;
		if (isEmpty()) {
			first = x;
			last = x;
		} else {
			last.next = x;
			last = x;
		}
		N++;
	}

	/**
	 * Remove and return the item on the queue least recently added. Throw an
	 * exception if the queue is empty.
	 */
	public Item dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue Underflow");
		}
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}
	/**
     * Return string representation.
     */
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(Item item : this){
			s.append(item + " ");
		}
		return s.toString();
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}

	/**
	 * To take advantage of Java's enhanced foreach syntax, the data type must
	 * implement Java's Iterable interface.
	 * 
	 * @author Fayaz
	 * 
	 */
	class ListIterator implements Iterator<Item>{

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	public static void main(String[] args){
		Queue<String> q = new Queue<String>();
		q.enqueue("to");
		q.enqueue("from");
		q.enqueue("add");
		q.enqueue("del");
//		System.out.println(q.dequeue());
//		q.dequeue();
		/**
		 * That is, the data type must implement a method named iterator() that
		 * returns an Iterator to the underlying collection. Since our Queue ADT
		 * now includes such a method, we simply need to declare it as
		 * implementing the Iterable interface and we are ready to use the
		 * foreach notation.
		 */
		for(String s : q){
			System.out.println(s);
		}
	}
}
