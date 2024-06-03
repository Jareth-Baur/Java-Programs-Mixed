import java.util.*;
public class BMI_Calculator{
	public static void main (String[] jareth){	
		Scanner SC = new Scanner (System.in);

		System.out.print("Input Height in Meters: ");
		double height = SC.nextDouble();

		System.out.print("Input Weight in Kilograms: ");
		double weight = SC.nextDouble();

		double new_height = (height*height);
		System.out.println();

		double BMI = (weight/new_height);

		if (BMI < 18.0) {
			System.out.println("Below Normal BMI "+BMI);
		}else if (BMI >= 18.0 || BMI <=24.9) {
			System.out.println("Normal BMI "+BMI);
		}else if (BMI > 24.9) {
			System.out.println("Above Normal BMI "+BMI);
		}
	}
}