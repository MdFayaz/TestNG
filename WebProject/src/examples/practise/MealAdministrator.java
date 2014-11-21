package examples.practise;


enum Meal {
	BREAKFAST(07, 30), LUNCH(12,15), DINNER(19,45);
	
	Meal(int hh, int mm){
		assert (hh >= 0 && hh <= 23): "Illegal hour.";
		assert (mm >= 0 && mm <= 59): "Illegal mins.";
		this.hh = hh;
		this.mm = mm;
	}
	
	private int hh, mm;
	
	public int getHour(){return this.hh;}
	public int getMins(){return this.mm;}
	
}

public class MealAdministrator {
	public static void main(String[] args) {
		System.out.printf(
				"Please note that no eggs will be served at %s %d:%d%n%n",
				Meal.BREAKFAST, Meal.BREAKFAST.getHour(),
				Meal.BREAKFAST.getMins());

		System.out.println("Meal times are as follow: \n");
		Meal[] meals = Meal.values();
		for (Meal meal : meals) {
			System.out.printf("%s served at %d:%d%n", meal, meal.getHour(),
					meal.getMins());
		}
		/*compute(new int[] {10, 11}, new int[] {12, 13, 14}); // (4)
		compute(15, 16); // (5)
		compute(new int[] {17, 18}, new int[][] {{19}, {20}}); // (6)
		compute(null, new int[][] {{21}, {22}});*/
	}
	
	/*static void compute(int... is){
		System.out.println("|");
		for(int i: is){
			System.out.println(i + "|");
		}
		System.out.println();
	}
	
	static void compute(int[] ia, int... is){
		compute(ia);
		compute(is);
	}
	
	static void compute(int[] inta, int[]... is){
		for(int[] ia: is){
			compute(ia);
		}
	}*/
}


