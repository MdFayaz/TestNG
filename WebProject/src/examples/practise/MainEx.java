package examples.practise;

public class MainEx extends Thread/* implements Runnable*/{

	public static void main(String[] args){
		System.out.println("in main");
		
		Integer i = 100;
		Integer j = 100;
		
		Integer a = new Integer("12");
		Integer b = new Integer("12");

		Integer x = 150;
		Integer y = 150;
		
		System.out.println("i == j " + (i == j));
		System.out.println("a == b " + (a == b));
		System.out.println("x == y " + (x == y));
	}
	
	/*public void run(){
		System.out.println("in run");
	}
	
	public static void main(){
		System.out.println("in overloaded method");
	}
	
	public static void main(String... args){
		System.out.println(args);
		
		Thread t = new Thread(new MainEx());
		t.start();
	}*/
	
	
}


