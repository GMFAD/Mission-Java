import java.util.Scanner;
import java.text.NumberFormat;

public class mortgageCalculator {
	final static byte MONTHS_IN_YEAR = 12;
	final static byte PERCENTAGE = 100;

	public static void main(String[] args) {

		int p;
        float annualInterest;
        byte years;		

		p = (int) readNumber("Principal: ", 1000, 1_000_000);
		annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
		years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculatedMortgage(p, annualInterest, years);

		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

		System.out.println("MORTGAGE \n--------");
		System.out.println("Monthly payments: " + mortgageFormatted);

		System.out.println("\nPAYMENTS SCHEDULE \n-----------------");
		for(short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
			double balance = calculatedBalance(p, annualInterest, years, month);
			System.out.println(NumberFormat.getCurrencyInstance().format(balance));
		}
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

		int n = years*MONTHS_IN_YEAR;
		float r = annualInterest/PERCENTAGE/MONTHS_IN_YEAR;

		double M = p*(r*Math.pow(1+r, n))/(Math.pow(1+r, n)-1);

        return M;
	}

	public static double calculatedBalance(int p, float annualInterest, byte years, short numberOfPaymentsMade) {
		int n = years*MONTHS_IN_YEAR;
		float r = annualInterest/PERCENTAGE/MONTHS_IN_YEAR;

		double balance = p * (Math.pow(1+r, n) - Math.pow(1+r, numberOfPaymentsMade)) / (Math.pow(1+r, n) - 1);
		
		return balance;
	}

}
