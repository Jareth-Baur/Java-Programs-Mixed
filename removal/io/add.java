import java.util.*;
import java.io.*;

public class add{
	public static void main(String [] args){
	Scanner in= new Scanner(System.in);

	try{
		
			FileWriter myWriter = new FileWriter("C:/Jean/books.txt",true);

							
					System.out.println("Enter Book ID: ");
					String bd = in.nextLine();


					System.out.println("Enter Book Title: ");
					String tt = in.nextLine();

					System.out.println("Enter Book Author: ");
					String au = in.nextLine();

					System.out.println("Enter Book Edition: ");
					String ed = in.nextLine();

					System.out.println("Enter Book Publisher: ");
					String pu = in.nextLine();

				
					System.out.println("Enter Book ISBN: ");
					String is = in.nextLine();

					

					myWriter.write(bd+";"+tt+";"+au+";"+ed+";"+pu+";"+is+";"+"1\n");
					myWriter.close();


	}catch(Exception e){

	}


	}
					
}