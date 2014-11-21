package ds.practise.chap04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublingStack<Item> implements Iterable<Item>{
	private Item[] a;
	private int N;
	
	public DoublingStack(){
		a = (Item[])new Object[2];
	}
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator<item> implements Iterator<Item>{
		private int i = N;
		
		public boolean hasNext(){
			return i > 0;
		}
		
		public Item next(){
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return a[--i];
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
	public void resize(int capacity){
		Item[] tempItem = (Item[])new Object[capacity];
		for(int i = 0; i < N ; i++){
			tempItem[i] = a[i];
		}
		a = tempItem;
	}
	
	public void push(Item item){
		if(N == a.length){
			resize(a.length * 2);
		}
		a[N++] = item;
	}
	
	public Item pop(){
		if(isEmpty()) {
			throw new RuntimeException("Stack Underflow");
		}
		Item item = a[N-1];
		a[N-1] = null;
		N--;
		if(N > 0 && N == a.length / 4){
			resize(a.length / 2);
		}
		return item;
	}
	
	public String toString(){
		String s = "[";
		for (int i = 0 ; i < N; i++){
			s += a[i] + " ";
		}
		s += "]";
		return s;
	}
	
	public boolean isEmpty(){
		return (N == 0);
	}
	
	public static void main(String[] args) {
		DoublingStack<String> stack = new DoublingStack<String>();
        stack.push("Hello");
        stack.push("World");
        stack.push("how");
        stack.push("are");
        stack.push("you");

        for (String s : stack)
            System.out.println(s);

        System.out.println();

        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
