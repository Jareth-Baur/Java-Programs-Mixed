import java.util.*;
import java.io.*;

public class edit{
	public static void main(String [] args){
	Scanner in = new Scanner(System.in);
	try{

		FileWriter myWriter = new FileWriter("C:/Jean/books_edit.txt",true);

		File myObj = new File("C:/Jean/books_edit.txt");
		Scanner myReader = new Scanner(myObj);

		System.out.print("Enter Book ID: ");
		String iD= in.nextLine();

		boolean found =false;

			String stat="Inactive";
			while(myReader.hasNextLine()){
				String [] details = new String [7];
				String data = myReader.nextLine();
				details=data.split(";");
				if(iD.equals(details[0])){
					found=true;
					System.out.println("Book Title: "+details[1]);
					System.out.println("Book Author: "+details[2]);
					System.out.println("Book Publisher: "+details[3]);
					System.out.println("Book Edition: "+details[4]);
					System.out.println("Book ISBN: "+details[5]);

					
					if(details[6].equals("1")){
						stat="Active";
					}
				}

			}
			myReader.close();

			if(found==false){
				System.out.print("No Book ID Registered in this Number.");
				System.exit(0);
			}

				System.out.println("Status: "+stat);

					System.out.println("---Book Edit Form--");

					System.out.print("Enter New Book Title: ");
					String name2 = in.nextLine();

					System.out.print("Enter Book Author: ");
					String au2 = in.nextLine();

					System.out.print("Enter Book Edition: ");
					String ed2 = in.nextLine();

					System.out.print("Enter Book Publisher: ");
					String pu2 = in.nextLine();

				
					System.out.print("Enter Book ISBN: ");
					String is2 = in.nextLine();

					File myObj2 = new File("C:/Jean/books_edit.txt");
					Scanner myReader2= new Scanner(myObj2);

					ArrayList<String> prev = new ArrayList<String>();
					while(myReader2.hasNextLine()){
						String data=myReader2.nextLine();
						prev.add(data);
					}
					myReader2.close();

					//CHANGE THE INFO

								FileWriter myWriterPs44 = new FileWriter("C:/Jean/books_edit.txt");
								for (int a = 0; a < prev.size(); a++) {
								    String[] details2 = prev.get(a).split(";");
								    if (details2.length >= 4 && iD.equals(details2[0])) {
								        myWriterPs44.write(iD+";"+name2+";"+au2+";"+ed2+";"+pu2+";"+is2+";"+"1\n");
								    }else{
								    	 myWriterPs44.write(prev.get(a) + "\n");
								    }
								}
								myWriterPs44.close();

					//CHANGE THE INFO


	}catch(Exception e){

	}
	}
}
