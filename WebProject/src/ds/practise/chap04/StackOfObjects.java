package ds.practise.chap04;

/**
 * Using inheritance, we can insert an object of any type. However, when we pop
 * it, we must cast it back to the appropriate type. This approach can expose us
 * to subtle bugs in our programs that cannot be detected until runtime. For
 * example, there is nothing to stop a programmer from putting different types
 * of objects on the same stack, then encountering a runtime type-checking error
 * as in the following example:
 * 
 * StackOfObjects stack = new StackOfObjects(); Apple a = new Apple(); Orange b
 * = new Orange(); stack.push(a); stack.push(b); a = (Apple) (stack.pop()); //
 * throws a ClassCastException b = (Orange) (stack.pop());
 * 
 * 
 * To avoid this runtime problems we have to use generics like in class
 * DoublingStack.java
 * 
 * @author Fayaz
 * 
 */
public class StackOfObjects {

	private Node first;
	private int N;
	
	private class Node {
		private Object item;
		private Node next;
	}

	public void push(Integer element){
		Node oldfirst = first;
		first = new Node();
		first.item = element;
		first.next = oldfirst;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public int size(){
		return N;
	}
	
	public Object pop(){
		if(isEmpty()){
			throw new RuntimeException("Stack Underflow");
		}
		Object item = first.item;
		first = first.next;
		return item;
	}
	
	public static void main(String[] args) {
		StackOfObjects soo = new StackOfObjects();
		soo.push(2);
		soo.push(3);
		soo.push(8);
		soo.pop();
	}

}
