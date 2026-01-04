import java.util.Scanner;
import java.text.NumberFormat;

public class mortgageCalculator {
	public static void main(String[] args) {

		int p;
        float annualInterest;
        byte years;

		Scanner snr = new Scanner(System.in);

		while (true) {
			System.out.print("Principal (1K-1M): ");
			p = snr.nextInt();
			if (p < 1000 || p > 1_000_000) {
				System.out.println("Enter a number between 1K to 1M");
				continue;
			}
			break;
		}

		while (true) {
			System.out.print("Annual Interest Rate: ");
			annualInterest  = snr.nextFloat();
			if (annualInterest < 1 || annualInterest > 30) {
				System.out.println("Enter a number between 1-30");
				continue;
			}
			break;
			}

		while (true) {
			System.out.print("Period (Years): ");
			years = snr.nextByte();
			if (years <1 || years >30) {
				System.out.println("Enter a number between 1-30");
				continue;
			}
			break;
		}

        double mortgage = calculatedMortgage(p, annualInterest, years);

		System.out.println(NumberFormat.getCurrencyInstance().format(mortgage));
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
