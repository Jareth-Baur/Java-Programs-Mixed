import java.util.*;
import java.io.*;

public class powersearch{
	public static void main(String [] args){
	Scanner in = new Scanner(System.in);
		try{


		FileWriter myWriter = new FileWriter("C:/Jean/books.txt",true);

						boolean unfound12=false;
						File myObj1121 = new File("C:/Jean/books.txt"); 
						Scanner myReader1121 = new Scanner(myObj1121);

						in = new Scanner(System.in);
						System.out.print("Enter Book ID or any key related to the book: ");
						String search121 = in.nextLine();
						
						System.out.println("Search result for "+search121);


						//DISLPAY  BOOKS

							System.out.println("Book ID\t\t\tName\t\t\t\tAuthor\t\t\tEdition\t\t\tPublisher\t\tISBN");
							System.out.println("--------------------------------------------------------------------------------------------------------------------------");	
							while (myReader1121.hasNextLine()) {
								String []details121 = new String[7];
								String data121 = myReader1121.nextLine(); 
								details121 = data121.split(";"); 
								if(data121.contains(search121)){
										System.out.println(details121[0]+"\t\t\t"+details121[1]+"\t\t\t"+details121[2]+"\t\t\t"+details121[3]+"\t\t\t"+details121[4]+"\t\t\t"+details121[5]);
										unfound12=true;
								}
							}
							if(unfound12==false){
									System.out.println("No Books Found!");
								}					
							myReader1121.close();

		}catch(Exception e){

		}
	}	
}


