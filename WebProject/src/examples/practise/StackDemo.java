package examples.practise;


public class StackDemo {

	private int index = -1;
	private int[] array;
	
	public static void main(String[] args) {
		StackDemo stackDemo = new StackDemo(8);
		stackDemo.push(12);
		System.out.println("top: "+ stackDemo.top());
		System.out.println("pop: "+ stackDemo.pop());
		System.out.println(stackDemo.top());
		stackDemo.push(32);
		stackDemo.push(17);
		stackDemo.push(25);
		stackDemo.push(86);
		
		stackDemo.display();
	}
	
	public StackDemo(int size){
		array = new int[size];
	}
	
	public void push(int element){
		if(array.length-1 == index){
			System.out.println("Stack is full");
			return;
		} else {
			array[++index] = element;
		}
	}
	
	private boolean isEmpty(){
		if(index < 0){
			System.out.print("Stack is empty ");
			return true;
		}
		return false;
	}
	
	
	public int top(){
		if(isEmpty()) {
			return index;
		}
		return array[index];
	}
	
	public int pop(){
		if(isEmpty()) {
			return index;
		}
			return array[index--];
	}
	
	public void display(){
		int tempArray[] = new int[index];
		System.out.println();
		System.out.print("[");
		for(int i = 0; i < index; i++ ){
			tempArray[i] = pop();
			System.out.print(tempArray[i] + ",");
		}
		System.out.print("]");
	}
}
