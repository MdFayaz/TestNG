package examples.practise;

public class HRACalculation {

	public static void main(String[] args) {
		
		boolean metroCity = Boolean.valueOf(args[0]);
		int basicSalary = Integer.parseInt(args[1]);
		int actualHRA = Integer.parseInt(args[2]);
		int actualRentPaid = Integer.parseInt(args[3]);
		
		int hraDeduction = 0;
		if (metroCity) {
			hraDeduction = ((basicSalary * 50) / 100);
		} else {
			hraDeduction = ((basicSalary * 40) / 100);
		}
		actualRentPaid = actualRentPaid - ((basicSalary * 10) / 100);
		
		int taxableHRA = Math.min(actualRentPaid, actualHRA);
		taxableHRA = Math.min(taxableHRA, hraDeduction);
		
		System.out.println(taxableHRA);
		
		double slabRate = 0.0;

	}
}
