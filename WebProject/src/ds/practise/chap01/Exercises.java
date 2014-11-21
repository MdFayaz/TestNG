package ds.practise.chap01;

public class Exercises {

	public static void main(String[] args) {
		int i = 0;
		while(i<10){
			System.out.println("Hello World");
			i++;
		}
		
		System.out.print("Hi " + args[2]);
		System.out.print(", " + args[1]);
		System.out.println(", " + args[0]);
		
		/**
		 * Write a program that uses Math.sin() and Math.cos() to check that the
		 * value of sin2θ + cos2θ is approximately 1 for any θ entered as a
		 * command-line argument. Just print the value. Why are the values not
		 * always exactly 1?
		 */
		double sin = Math.sin(Double.parseDouble(args[3]));
		double cos= Math.cos(Double.parseDouble(args[4]));
		
		double result = (sin * sin) + (cos * cos);
		System.out.print("Trignomentry result: " + result);
		
		/**
		 * Suppose that a and b are boolean values. Show that the expression
		 * (!(a && b) && (a || b)) || ((a && b) || !(a || b)) is equivalent to
		 * true.
		 * 
		 */
		boolean a = false;
		boolean b = false;
		System.out.println("boolean value: " + ((!(a && b) && (a || b)) || ((a && b) || !(a || b))));
		
		/**
		 * What do each of the following print?
		 */
		System.out.println("'b': " + 'b');
		System.out.println("('b' + 'c'): " + ('b' + 'c'));
		System.out.println("((char)('a' + 4)): " + (char) ('a' + 4));
		
		/**
		 * Suppose that a and b are int values. Simplify the following
		 * expression: (!(a < b) && !(a > b))
		 */
		int x = 12;
		int y = 5;
		System.out.println((!(x < y)) && !(x > y));
		System.out.println("Simplified form: " + (x == y));
		
		/**
		 * Suppose that a variable a is declared as int a = 2147483647 (or
		 * equivalently, Integer.MAX_VALUE). What do each of the following
		 * print?
		 */
		int integer = 2147483647 ;
		System.out.println("integer		: " + integer);
		System.out.println("(integer + 1)	: "+ (integer + 1));
		System.out.println("(2 - integer)	: " + (2 - integer));
		System.out.println("(-2 - integer)	: " + (-2 - integer));
		System.out.println("(2 * integer)	: "+ (2 * integer));
		System.out.println("(4 * integer)	: " + (4 * integer));
		
		/**
		 * Suppose that a variable a is declared as double a = 3.14159. What do
		 * each of the following print?
		 */
		double d = 3.14159;
		System.out.println("d: "  + d);
		System.out.println("(d + 1): " + (d + 1));
		System.out.println("(8 / (int) d): " + (8 / (int) d));
		System.out.println("(8 / d): " + (8 / d));
		System.out.println("(int)(8 / d): " + (int) (8 / d));
		/**
		 * What is the value of (Math.sqrt(2) * Math.sqrt(2) == 2)?
		 */
		/**
		 * Give the value of a after the execution of each of the following sequences:
		 */
		x = 1;
		x = x + x;
		x = x + x;
		x = x + x;
		System.out.println("x: " + x);
		
		x = 2;
		x = x * x;
		x = x * x;
		x = x * x;
		System.out.println("x: " + x);
		
		a = true;
		a = !a;
		a = !a;
		a = !a;
		System.out.println("a: " + a);
		
		/**
		 * Write a program that takes two int values a and b from the command
		 * line and prints a random integer between a and b.
		 */
		x = Integer.parseInt(args[3]);
		y = Integer.parseInt(args[4]);
		System.out.println(Math.random() + Math.min(x, y));
		/**
		 * Read in Cartesian coordinates (x, y) and print out polar coordinates
		 */
		double theta = Math.atan2(sin, cos);
		System.out.println("theta: " + theta);
		/**
		 * Day of week
		 */
		
		double day = 3.0;
		double month = 5.0;
		double year = 11.0;
		
		double y0 = year - (14 - month) / 12;
		
	}
}
