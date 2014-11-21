package ds.practise.chap04;

/*************************************************************************
 *  Compilation:  javac LinkedStackOfStrings.java
 *  Execution:    java LinkedStackOfStrings
 *
 *  A stack of strings, implemented using a linked list.
 *  
*  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java LinkedStackOfStrings < tobe.txt 
 *  to be not that or be
 *  
 *************************************************************************/


public class LinkedStackOfString {

	private int N;
	private Node first;

	private class Node {
		private String item;
		private Node next;
	}

	public int size(){
		return N;
	}

	public void push(String element) {
		Node oldfirst = first;
		first = new Node();
		first.item = element;
		first.next = oldfirst;
		N++;
	}

	public String pop() {
		if (isEmpty())
			throw new RuntimeException("Stack Underflow");
		String item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public String toString() {
		String s = "";
		for (Node node = first; node != null; node = first.next) {
			s += node.item + " ";
		}
		return s;
	}

	public static void main(String[] args) {
		LinkedStackOfString lsos = new LinkedStackOfString();
		lsos.push("to");
		lsos.push("from");
		lsos.push("be");
		lsos.push("not");
		
		while(lsos.size() > 0){
			System.out.println(lsos.pop());	
		}
	}

}
