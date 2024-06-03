import java.util.*;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class logForm{
	public static void main(String [] args){
	Scanner in = new Scanner(System.in);
		try{
			boolean loginSuccess =false;

			FileWriter myWriter = new FileWriter("C:/Jean/pass.txt",true);

				File logs2 = new File("C:/Jean/pass.txt");

	                        Scanner loginReader = new Scanner(logs2);
	                        String uname = "", pword = "";
	                        if (loginSuccess == false) {
	                            System.out.println("---Login Form---");
	                            in = new Scanner(System.in);

	                            System.out.print("Username: ");
	                            uname = in.nextLine();

	                            System.out.print("Password: ");
	                            pword = in.nextLine();
	                        }
	                        while (loginReader.hasNextLine()) {
	                            String[] details = new String[7];
	                            String data = loginReader.nextLine();
	                            details = data.split(";");
	                            if (uname.equals(details[0]) && pword.equals(details[1])) {
	                                loginSuccess = true;
	                                break;
	                            }
	                        }
	                        if(loginSuccess==true){
	                        	 System.out.println("LOG IN SUCCESSFULLY");
	                        	   System.out.println("---Menu---");
	                            System.out.println("1 = Add Student ");
	                            System.out.println("2 = Add Book");
	                            System.out.println("3 = Add Accession");
	                            System.out.println("4 = Search Book");
	                            System.out.println("5 = Borrow Book");
	                            System.out.println("6 = Search Borrowed Books");
	                            System.out.println("7 = Return Book");
	                            System.out.println("8 = Search Returned Books");
	                            System.out.println("9 = Log Out");
	                        }else{
	                        	System.out.print("Invalid Username or Password");
	                        }
		}catch(Exception e){

		}
	}	
}


