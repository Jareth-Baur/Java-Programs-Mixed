import java.util.*;
public class SalaryLadder{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);
		int daysworked = 0;
		Double dailyWage = 0.0, sss = 250.0, phil = 150.0, pagibig = 150.0, initialSalary = 0.0, tax = 0.0, grossSalary = 0.0;

		System.out.print("Enter days worked: ");
		daysworked = SC.nextInt();

		System.out.print("Enter daily wage: ");
		dailyWage = SC.nextDouble();

		initialSalary = (daysworked * dailyWage);

		if (dailyWage <= 300){
			tax = initialSalary * 0.01;
		}else if (dailyWage > 300 && dailyWage <= 400){
			tax = initialSalary * 0.03;
		}else if (dailyWage > 400 && dailyWage <= 500){
			tax = initialSalary * 0.04;
		}else{
			tax = (initialSalary * 0.06);
		}

		grossSalary = initialSalary - ( sss + pagibig + phil + tax );

		System.out.print("The gross salary is: "+grossSalary);
	}
}