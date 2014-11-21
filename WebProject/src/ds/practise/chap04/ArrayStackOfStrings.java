package ds.practise.chap04;

import java.util.Iterator;

/*************************************************************************
 *  Compilation:  javac ArrayStackOfStrings.java
 *  Execution:    java ArrayStackOfStrings
 *  
 *  Stack of strings implementation with a fixed-size array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java ArrayStackOfStrings 5 < tobe.txt 
 *  to be not that or be
 *
 *************************************************************************/

public class ArrayStackOfStrings implements Iterable<String> {

	public Iterator<String> iterator() {
		return new ArrayIterator();
	}

	class ArrayIterator implements Iterator<String> {
		private int i = N - 1;

		public boolean hasNext() {
			return i >= 0;
		}

		public String next() {
			return a[i--];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private String[] a;
	private int N;

	public ArrayStackOfStrings(int size) {
		this.a = new String[size];
	}

	public void push(String element) {
		if (N == a.length) {
			System.out.println("Stack Overflow");
			return;
		}
		a[N++] = element;
	}

	public String pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack Underflow");
		}
		return a[--N];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean isFull(){
		return (N == a.length);
	}
	
	public static void main(String[] args) {
		ArrayStackOfStrings asos = new ArrayStackOfStrings(50);
		/*
		 * asos.push("to");
		 * asos.push("from"); 
		 * asos.push("be");
		 * asos.push("not");
		 * System.out.println(asos.isFull()); 
		 * String ele = asos.pop();
		 * System.out.println(ele);
		 * System.out.println(asos.isFull());
		 * 
		 */
		String input = "it was - the best - of times - - - it was - the - -  ";
		String[] subInput = input.split(" ");
		for (String s : subInput) {
			if (!s.equals("-"))
				asos.push(s);
		}
		Iterator<String> it = asos.iterator();
		String item = "";
		int itemLength = 0;
		while (it.hasNext()) {
			String temp = it.next();
			int maxLength = temp.length();
			if (maxLength > itemLength) {
				itemLength = maxLength;
				item = temp;
			}
		}
		System.out.println(item + " length " + itemLength);
	}

	
}
