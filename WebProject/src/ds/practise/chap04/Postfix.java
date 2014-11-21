package ds.practise.chap04;

public class Postfix {

	public static void main(String[] args) {
		StackOfObjects sob = new StackOfObjects();
//		String string = "7 16 * 5 + 16 * 3 + 16 * 1 +";
		String string = "1 2 3 4 5 * + 6 * * +";
		String[] sub = string.split(" ");
		for (String s : sub) {
			if (s.equals("+")) {
				sob.push((Integer) sob.pop() + (Integer) sob.pop());
			} else if (s.equals("*")) {
				sob.push((Integer) sob.pop() * (Integer) sob.pop());
			} else {
				sob.push(Integer.parseInt(s));
			}
		}
		System.out.println(sob.pop());
	}
}
