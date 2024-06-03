import java.util.*;
public class TernaryOperator{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Please input your name: ");
		String name = sc.nextLine();

		System.out.print("Please input grade for prelim: ");
		int prelim = sc.nextInt();

		System.out.print("Please input grade for midterm: ");
		int midterm = sc.nextInt();

		System.out.print("Please input grade for final: ");
		int finals = sc.nextInt();

		double average = ( (prelim * 0.30) + (midterm * 0.30) + (finals * 0.40) );
		String equi="";
		equi = ( average >= 99.0 && average <= 100.0 )?
						" 1.0":
						""+equi+"";
		equi = ( average >= 96.0 && average <= 98.0 )?
						" 1.25":
						""+equi+"";
		equi = ( average >= 93.0 && average <= 95.0 )?
						" 1.50":
						""+equi+"";
		equi = ( average >= 90.0 && average <= 92.0 )?
						" 1.75":
						""+equi+"";
		equi = ( average >= 87.0 && average <= 89.0 )?
						" 2.00":
						""+equi+"";
		equi = ( average >= 84.0 && average <= 86.0 )?
						" 2.25":
						""+equi+"";
		equi = ( average >= 81.0 && average <= 83.0 )?
						" 2.50":
						""+equi+"";
		equi = ( average >= 78.0 && average <= 80.0 )?
						" 2.75":
						""+equi+"";
		equi = ( average >= 75.0 && average <= 77.0 )?
						" 3.0":
						""+equi+"";
		equi = ( average >= 72.0 && average <= 74.0 )?
						" 4.0":
						""+equi+"";
		equi = ( average >= 69.0 && average <= 71.0 )?
						" 5.0":
						""+equi+"";							
		equi = ( average == 0 && average == 0 )?
						" INC":
						""+equi+"";
		String remarks = ( average >= 75 )?
					"Congratulations "+name+", You Passed with an average of "+ average+", With an equivalent Grade to Dorsu of"+equi:
					"Sorry "+name+", You Failed with an average of "+average+", With an equivalent Grade to Dorsu of"+equi;
		System.out.println(remarks);

















		/*
		int a, b, c=13;
		a = 10;
		b= (a>1 || a>c) ? 20: 30;
		//			   T   F
		System.out.println("value of b is: "+ b);

		b= (a == 10) ? 20: 30;
		//			   T   F
		System.out.println("value of b is: "+ b);

		String name="Kevin", name2="Mark";
		String holder= ( name.equals(name2) )? "They are equal": "They are not equal";
		System.out.println(holder); 
		*/


	}

}