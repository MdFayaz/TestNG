package examples.practise;

enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

enum Meals {

	BREAKFAST(7, 30) {
		public double mealPrice(Day day) {
			double breakfastPrice = 10.50;
			if (day.equals(Day.SATURDAY) || day.equals(Day.SUNDAY)) {
				breakfastPrice *= 1.5;
			}
			return breakfastPrice;
		}

		public String toString() {
			return "BREAKFAST";
		}
	},

	LUNCH(12, 15) {
		public double mealPrice(Day day) {
			double lunchPrice = 20.50;
			switch (day) {
			case SATURDAY:
			case SUNDAY:
				lunchPrice *= 2.0;
			default:
				break;
			}
			return lunchPrice;
		}

		public String toString() {
			return "LUNCH";
		}
	},

	DINNER(19, 45) {
		public double mealPrice(Day day) {
			double dinnerPrice = 25.50;
			if (day.equals(Day.SATURDAY) || day.equals(Day.SUNDAY)) {
				dinnerPrice *= 2.5;
			}

			return dinnerPrice;
		}

		public String toString() {
			return "DINNER";
		}
	};

	Meals(int hh, int mm) {
		this.hh = hh;
		this.mm = mm;
	}

	abstract double mealPrice(Day day);

	private int hh, mm;
	
	public int getHour() {
		return this.hh;
	}

	public int getMins() {
		return this.mm;
	}
}

public class MealPrices{
	public static void main(String[] args) {
		System.out.printf("Please note that %s, %02d:%02d on %s costs Rs %.2f/- %n",
				Meal.BREAKFAST.name(), 
				Meal.BREAKFAST.getHour(), 
				Meal.BREAKFAST.getMins(), 
				Day.MONDAY, 
				Meals.BREAKFAST.mealPrice(Day.MONDAY));
		
		System.out.println("Meal Prices on " + Day.SATURDAY + "are as follows:");
		Meals[] meals = Meals.values();
		for(Meals meal : meals){
			System.out.printf("%s costs %.2f%n", meal, meal.mealPrice(Day.SATURDAY));
		}
	}
}