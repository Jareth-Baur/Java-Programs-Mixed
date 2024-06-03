import java.util.*;
import java.io.*;

public class active{
	public static void main(String [] args){
	Scanner in= new Scanner(System.in);

		try {
		FileWriter myWriter = new FileWriter("C:/Jean/books.txt", true);
		File myObj = new File("C:/Jean/books.txt");
		Scanner myReader = new Scanner(myObj);

		System.out.print("Enter Book ID: ");
		String iD = in.nextLine();
		String stat = "";

		while (myReader.hasNextLine()) {
			String[] details = new String[6];
			String data = myReader.nextLine();
			details = data.split(";");
			if (iD.equals(details[0])) {
				if (details[6].equals("1")) {
					System.out.print("Deactivated Successfully.");
					stat = "0";
				} else if (details[6].equals("0")) {
					System.out.print("Activated Successfully.");
					stat = "1";
				}
			}
		}

		myReader.close();

					File myObj2 = new File("C:/Jean/books.txt");
					Scanner myReader2= new Scanner(myObj2);

					ArrayList<String> prev = new ArrayList<String>();
					while(myReader2.hasNextLine()){
						String data=myReader2.nextLine();
						prev.add(data);
					}
					myReader2.close();

					//CHANGE THE INFO

								FileWriter myWriterPs44 = new FileWriter("c:/Jean/books.txt");
								for (int a = 0; a < prev.size(); a++) {
								    String[] details2 = prev.get(a).split(";");
								    if (details2.length >= 4 && iD.equals(details2[0])) {
								        myWriterPs44.write(details2[0]+";"+details2[1]+";"+details2[2]+";"+details2[3]+";"+details2[4]+";"+details2[5]+";"+stat+"\n");
								    }else{
								    	 myWriterPs44.write(prev.get(a) + "\n");
								    }
								}
								myWriterPs44.close();


	} catch (Exception e) {
		e.printStackTrace();
	}
}



				
}