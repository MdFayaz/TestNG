package ds.practise.chap04;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*************************************************************************
 *  Compilation:  javac DoublingStackOfStrings.java
 *  Execution:    java DoublingStackOfStrings
 *  
 *  Stack of strings implementation with an array.
 *  Resizes by doubling and halving.
 *
 *************************************************************************/

public class DoublingStackOfStrings implements Iterable<String> {

	private int N;
	private String[] a;

	public Iterator<String> iterator() {
		return new ReverseArrayIterator();
	}

	class ReverseArrayIterator implements Iterator<String> {
		int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public String next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return a[--i];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public int size(){
		return N;
	}
	
	public DoublingStackOfStrings(int size) {
		a = new String[size];
	}

	public void push(String element) {
		if (a.length == N) {
			resize(a.length * 2);
		}
		a[N++] = element;
	}

	public String pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack Underflow");
		}
		String item = a[--N];
		a[N] = null;
		if (N > 0 && N == (a.length / 4)) {
			resize(a.length / 2);
		}
		return item;
	}

	public boolean isEmpty() {
		return (N == 0);
	}

	private void resize(int capacity) {
		String[] tempArray = new String[capacity];
		for (int i = 0; i < N; i++) {
			tempArray[i] = a[i];
		}
		a = tempArray;
	}

	public static void main(String[] args) {
		DoublingStackOfStrings dsos = new DoublingStackOfStrings(4);
		System.out.println(dsos.size());
		dsos.push("to");
		dsos.push("from");
		dsos.push("be");
		dsos.push("that");
		System.out.println(dsos.size());
		while(dsos.size() > 0){
			System.out.println(dsos.pop());
		}
	}

}
