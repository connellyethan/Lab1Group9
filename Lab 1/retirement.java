import java.text.DecimalFormat;
import java.util.Scanner;

public class retirement {

	private static Scanner inputs;
	
	public static void main(String[] args) {
		// variables // 
		inputs = new Scanner (System.in);
		
		double r;
		double n;
		double y;
		double p;
		double f;
		boolean t;
		
		double years_worked, years_retired, annual_return_invest, required_income, ssi_income, annual_return_pay;
		
		// Prompts user for input data // 
		System.out.print("How many years do you plan to work?:");
		years_worked = inputs.nextDouble();
		
		System.out.print("What is your Annual Return Invested (0-20%):");
		annual_return_invest = inputs.nextDouble();
			
		System.out.print("How many years do you plan to draw retirement?:");
		years_retired = inputs.nextDouble();	
		
		System.out.print("What is your Annual Return PayBack (0-3%):");
		annual_return_pay = inputs.nextDouble();
		
		System.out.print("What is your required income?");
		required_income = inputs.nextDouble();
		
		System.out.print("What is your monthly SSI income?");
		ssi_income = inputs.nextDouble();
		
		// Present Value calculation + variables //
		double PV;
		r = (annual_return_pay/100)/12;
		n = years_retired*12;
		y = required_income-ssi_income;
		f = 0;
		t = false;
		double rate = r + 1;
		PV = (((1 - Math.pow(rate, n))/r)*(t ? rate : 1)* y - f)/Math.pow(rate, n);
		
		// Payment per month formula + variables // 
		double PMT;
		r = (annual_return_invest/100)/12;
		n = years_worked*12;
		p = 0;
		f = PV;
		t = false;
		double rate1 = r + 1;
		
		PMT =(f+p*Math.pow(rate1, n))*r/((t ? rate1 : 1)*(1 - Math.pow(rate1, n)));
		
		// Converts PMT to 100's place decimal // 
		DecimalFormat dec = new DecimalFormat("#.##"); 
		
		// Final Print statement from user input // 
		System.out.println("You will have to save $" + dec.format(PMT) + " each month to meet your request.");
	}
}