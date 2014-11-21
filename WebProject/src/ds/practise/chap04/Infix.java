package ds.practise.chap04;

public class Infix {

	public static void main(String[] args) {
		ArrayStackOfStrings asos = new ArrayStackOfStrings(30);
		String string = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
		String[] substring = string.split(" ");
		for (String s : substring) {
			if (s.equals("+")) {
				asos.push(s);
			} else if (s.equals("*")) {
				asos.push(s);
			} else if (s.equals(")")) {
				System.out.println(asos.pop() + " ");
			} else if (s.equals("(")) {
//				System.out.println("");
			} else {
				System.out.println(s + " ");
			}
		}
		System.out.println();
	}
}
