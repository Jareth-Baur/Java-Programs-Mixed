import java.util.*;
  public class DominicRuelo_ternaryOperator2{
	   public static void main(String[] args) {
	Scanner nice = new Scanner( System.in);
System.out.print("Please Enter Your Name: ");
String name = nice.nextLine();
      System.out.print("Please Input Grade in prelim: ");
      int prelim = nice.nextInt();
      System.out.print("Please Input Grade in Midterm: ");
      int midterm = nice.nextInt();
      System.out.print("Please Input Grade in Final: ");
      int finals = nice.nextInt();
      double average = (prelim*0.30) + (midterm*0.30) + (finals*0.40);
      
      
      String equi = "";
	equi = ( average >= 99.0  &&  average <= 100)? "1.0":
                   ""+equi;
    equi = ( average >= 96.0  &&  average <= 98.0)? "1.25":
                   ""+equi; 
    equi = ( average >= 93.0  &&  average <= 95.0)? "1.50":
                   ""+equi;
     equi = ( average >= 90.0  &&  average <= 92.0)? "1.75":
                   ""+equi;
      equi = ( average >= 87.0  &&  average <= 89.0)? "2.0":
                   ""+equi;
       equi = ( average >= 84.0  &&  average <= 86.0)? "2.25":
                   ""+equi;
        equi = ( average >= 81.0  &&  average <= 83.0)? "2.50":
                   ""+equi;
         equi = ( average >= 78.0  &&  average <= 80.0)? "2.75":
                   ""+equi;
          equi = ( average >= 75.0  &&  average <= 77.0)? "3.0":
                   ""+equi;
           equi = ( average >= 72.0  &&  average <= 74.0)? "4.0":
                   ""+equi;
            equi = ( average <= 71.0 )? "5.0":
                   ""+equi;   
            equi = ( average <= 70.0)? "INC":
                   ""+equi;  
             String remarks = ( average >= 75)? "Congratulations "+name+", You Passed with an average grade of "+average + ", the equivalent is: "+equi: " sorry  "+name+", You Faild with an average grade of "+average + ", the equivalent is: " +equi;
             System.out.print(remarks);    
                 
     	}
}