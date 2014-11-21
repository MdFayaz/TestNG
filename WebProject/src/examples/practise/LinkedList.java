package examples.practise;


public class LinkedList {

	private Node start;
	
	
	
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		
	/*	list.addAtFirstNode(32);
		list.addAtFirstNode(33);
		list.addAtFirstNode(34);
		list.addAtFirstNode(35);*/
		
		list.addAtLastNode(32);
		list.addAtLastNode(33);
		list.addAtLastNode(34);
		list.addAtLastNode(35);
		list.display();
		list.insertAt(3, 2);
		list.display();
		list.insertAt(120, 0);
		
//		list.displayInReverseOrder(list.start);
		list.reverse();
		list.display();
	}
	
	/**
	 * Insert at beginning node
	 */
	public void addAtFirstNode(int ele){
		
		Node newNode = new Node(ele);
		if(start == null){
			start = newNode;
		} else {
			newNode.setNextNode(start);
			start = newNode;
		}
	}
	
	/**
	 * Insert at last node
	 */
	public void addAtLastNode(int ele){
		Node newNode = new Node(ele);
		if(start == null){
			start = newNode;
		}else{
			Node node = start;
			while(node.getNextNode() != null){
				node = node.getNextNode();
			}
			node.setNextNode(newNode);
		}
	}
	
	/**
	 * Insert at given node
	 */
	public void insertAt(int ele, int nodeLocation){
		Node newNode = new Node(ele);
		if((start == null && nodeLocation >= 0) || nodeLocation == 0 ){
			System.out.println("No node can be created at given location");
		} else if(start == null){
				start = newNode;
		} else if(count() == nodeLocation){
				addAtLastNode(ele);
		} else {
			Node node = start;
			for(int count = 1; node != null && count < nodeLocation; node = node.getNextNode(), count++);
			newNode.setNextNode(node.getNextNode());
			node.setNextNode(newNode);
		}
	}
	
	/**
	 * display linked list elements
	 */
	public void display(){
		System.out.print(start.getElement());
		for(Node node = start.getNextNode(); node != null; node = node.getNextNode()){
			System.out.print(" -> " + node.getElement());
		}
		System.out.println();
	}
	
	public void displayInReverseOrder(Node node){
		if(node == null){
			return;
		}
		displayInReverseOrder(node.getNextNode());
		System.out.print(node.getElement() + " -> ");
	}
	
	public void reverse(){
		Node node = start;
		Node fNode = node.getNextNode();
		Node sNode = fNode.getNextNode();
		
		while(fNode != null){
			fNode.setNextNode(node);
			node = fNode;
			fNode = sNode;
			if(sNode != null){
				sNode = sNode.getNextNode();
			}
		}
		start.setNextNode(null);
		start = node;
	}
	
	public int count(){
		int count =0;
		Node node = start;
		while(node != null){
			node = node.getNextNode();
			count++;
		}
		return count;
	}
}

class Node {
	private int element;
	private Node nextNode;
	
	public Node(int ele){
		this.element = ele;
		this.nextNode = null;
	}
	
	public void setNextNode(Node node){
		this.nextNode = node;
	}
	
	public Node getNextNode(){
		return this.nextNode;
	}
	
	public int getElement(){
		return this.element;
	}
}