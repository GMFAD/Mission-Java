import java.util.Scanner;
import java.text.NumberFormat;

public class mortgageCalculator {
	public static void main(String[] args) {

		int p;
        float annualInterest;
        byte years;		

		p = (int) readNumber("Principal: ", 1000, 1_000_000);
		annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
		years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculatedMortgage(p, annualInterest, years);

		System.out.println(NumberFormat.getCurrencyInstance().format(mortgage));
	}

	public static double readNumber(String prompt, double min, double max) {

		Scanner snr = new Scanner(System.in);
		double value;
		while (true) {
			System.out.print(prompt);
			value = snr.nextDouble();
			if (value < min || value > max) {
				System.out.println("Enter a number between " + min + " and " + max);
				continue;
			}
			break;
		}
		return value;
		
	}

	public static double calculatedMortgage(int p, float annualInterest, byte years) {

		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENTAGE = 100;

		int n = years*MONTHS_IN_YEAR;
		float r = annualInterest/PERCENTAGE/MONTHS_IN_YEAR;

		double M = p*(r*Math.pow(1+r, n))/(Math.pow(1+r, n)-1);

        return M;
	}
}
