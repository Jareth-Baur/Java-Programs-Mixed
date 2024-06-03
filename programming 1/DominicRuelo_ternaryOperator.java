import java.util.*;
public class DominicRuelo_ternaryOperator {
	public static void main(String[] args) {
	Scanner nice = new Scanner( System.in);
      System.out.print("Please Input Grade in prelim: ");
      int prelim = nice.nextInt();
      System.out.print("Please Input Grade in Midterm: ");
      int midterm = nice.nextInt();
      System.out.print("Please Input Grade in Final: ");
      int finals = nice.nextInt();
      double average = (prelim*0.20) + (midterm*0.20) + (finals*0.60);   
      String equi = "";
	equi = ( average > 90.0  &&  average <= 100)? "Excellent performance":
                   ""+equi;
    equi = ( average >= 75.0  &&  average <= 90.0)? "Satisfactory performance":
                   ""+equi; 
    equi = ( average < 75.0)? "poor preformance":
                   ""+equi;
             System.out.print(equi);         
     	}
}