package examples.practise;

public class Stack {

	private int N;
	private Node first;
	
	public void push(String item){
		Node oldFirst = first;
		first = new Node();
		first.element = item;
		first.nextNode = oldFirst;
		N++;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public String pop(){
		if(isEmpty()) throw new RuntimeException("Stack Underflow");
		String item = first.element;
		first = first.nextNode;
		N--;
		return item;
	}
	
	class Node{
		private String element;
		private Node nextNode;
		
	/*public Node(String element){
			this.element = element;
			this.nextNode = null;
		}
		
		public void setNode(Node node){
			this.nextNode = node;
		}
		
		public Node getNode(){
			return this.nextNode;
		}
		
		public String getElement(){
			return this.element;
		}*/
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push("ac");
		s.push("ac");
		s.push("ac");
		s.push("ac");
		System.out.println(s.pop());
	}
	
}
