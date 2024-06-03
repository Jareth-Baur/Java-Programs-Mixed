import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Library_Management_System{
	public static void main(String []pos){
			Scanner in = new Scanner(System.in);
		try {
			boolean loginSuccess=false;
			boolean loop = false;
			boolean signUp=false;
			 boolean check=false;

			do{
				FileWriter myWriter = new FileWriter("C:/FinalSystem/books.txt",true);
				FileWriter myWriterA = new FileWriter("C:/FinalSystem/accession.txt",true);
				FileWriter myWriterB = new FileWriter("C:/FinalSystem/borrow.txt",true);
				FileWriter logs = new FileWriter("C:/FinalSystem/users.txt",true);
				FileWriter records = new FileWriter("C:/FinalSystem/students.txt",true);
				FileWriter officialRecords = new FileWriter("C:/FinalSystem/students_Official_Records.txt",true);
				FileWriter userNames = new FileWriter("C:/FinalSystem/userNames.txt",true);

				in = new Scanner(System.in);

				//LOG IN & SIGN UP 

				int choice=0;
				   if (loginSuccess==false) {
                    do {
                        in = new Scanner(System.in);
                        try {
                            System.out.println("++++++++++++++++++++++++++++++++");
							System.out.println("+        ---WELCOME---         +");
							System.out.println("+     ---LiBrary System---     +");
							System.out.println("+                              +");
							System.out.println("+    Press '1' to Signup       +");
							System.out.println("+    Press '2' to Login        +");
							System.out.println("+    Press '3' to Exit         +");
							System.out.println("+                              +");
							System.out.println("++++++++++++++++++++++++++++++++");

                            System.out.println("\tEnter Your Choice ");
                            System.out.print("\t\t");
                            choice = in.nextInt();
                        } catch (Exception e) {
                        }
                        if (choice <= 0 || choice > 3) {
                            System.out.println("Invalid Input! Please input number ranging from 1-3");
                        }
                    } while (choice <= 0 || choice > 3);
                }

                 if (loginSuccess == false) {

                    switch (choice) {
                    case 1:
                    	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
                    	System.out.println("+++++++++++++++++++++");
						System.out.println("+   Signup Form     +");
						System.out.println("+++++++++++++++++++++");
						
                            File login = new File("C:/FinalSystem/users.txt");
                            Scanner signupReader = new Scanner(login);

                            boolean sUP = true, confirm = true;
                            
                            String name="", word="";
                            String [] detail = new String [5];
                            in = new Scanner(System.in);

                            while (signupReader.hasNextLine()) {
                                
                                String datas = signupReader.nextLine();

                                detail = datas.split(";");
                            }

                            String sname,mid,last;

                         do {
						    System.out.print("Enter First Name: ");
						    sname = in.nextLine();

						    if (sname.isBlank()) {
						        System.out.println("Please enter a value for First Name.");	
						        }	

						}while(sname.isBlank());

						 do {

						    System.out.print("Enter Middle Name: ");
						    mid = in.nextLine();

						    if (mid.isBlank()) {
						        System.out.println("Please enter a value for Middle Name.");						     
						    }
						    }while(mid.isBlank());

						 do { 

						    System.out.print("Enter Last Name: ");
						    last = in.nextLine();

						      if (last.isBlank()) {
						        System.out.println("Please enter a value for Last Name.");						     
						    }

						    }while(last.isBlank());



                        	//Checks existing usser names

		                         File libro234 = new File("C:/FinalSystem/userNames.txt");
		        				Scanner bReader234= new Scanner(libro234);

								String ngalan4="";

								while(bReader234.hasNextLine()){
									ngalan4 = bReader234.nextLine();

								}
								bReader234.close();
								boolean tigcheck4 = true;
								String name1 = "";

								do{

								while (tigcheck4==true) {
									do{
								    System.out.print("Username: ");
								    name1 = in.nextLine();

								     if (name1.isBlank()) {
						    		    System.out.println("Please enter a value for Username.");						     
						  		 	 }
								}while(name1.isBlank());
								    if (ngalan4.contains(";"+name1+"|")) {
								        System.out.println("Username already been used.");					       
								    } else {
								        tigcheck4= false;
								    }
								}
									//Checks existing usser names

                            
	                            System.out.print("Password: ");
	                            word = in.nextLine();

                            	if(word.isBlank() || name1.isBlank()){
                            		System.out.println("Please enter a value for Password.");
                            	}

                        	}while(word.isBlank() || name1.isBlank());
                           
                            logs.write(sname + ";" +mid +";"+last+";"+ name1 + ";" + word + ";1\n");

                            logs.close();

                            userNames.write(";"+name1+"|");
                            userNames.close();
                            System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
                            System.out.println("Signup Successfully");
                             signUp = true;
                          	 check=true;
                          	 System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
                        break;
                         case 2:
                         	File logs2 = new File("C:/FinalSystem/users.txt");
	                        Scanner loginReader = new Scanner(logs2);
	                        String uname = "", pword = "";
	                         check=false;
	                        if (loginSuccess == false) {
	                        	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
	                            System.out.println("++++++++++++++++++++++");
								System.out.println("+    Login Form      +");
								System.out.println("++++++++++++++++++++++");
	                            in = new Scanner(System.in);

	                            do{

	                            System.out.print("Username: ");
	                            uname = in.nextLine();

	                            if(uname.isBlank()){
	                            	System.out.println("Please input your username.");
	                            }

	                        }while(uname.isBlank());

	                         do{
	                           
	                            System.out.print("Password: ");
	                            pword = in.nextLine();

	                            if(pword.isBlank()){
	                            	System.out.println("Please input your password.");
	                            }

	                        }while(pword.isBlank());

	                        }
	                       

	                        while (loginReader.hasNextLine()) {
	                            String[] details = new String[5];
	                            String data = loginReader.nextLine();

	                            details = data.split(";");
	                            if (uname.equals(details[3]) && pword.equals(details[4])) {
	                                loginSuccess = true;
	                                check=true;
	                                break;
	                            }
	                        }
	                        break;
	                        
	                    case 3:
	                    	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
	                        System.out.println("Exiting...");
	                        System.exit(300);
	                        break;
	                    }
	                }

	                //LOG IN & SIGN UP 

	                //CHOOSING

				int choice1 = 0;

				if (loginSuccess == true) {
				    in = new Scanner(System.in);
				    try {
				    	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
				  	System.out.println("++++++++++++++++++++++++++++++++++++");
					System.out.println("+              MENU                +");
					System.out.println("+                                  +");
					System.out.println("+ 1. Add Student                   +");
					System.out.println("+ 2. Add Book                      +");
					System.out.println("+ 3. Add Accession                 +");
					System.out.println("+ 4. Search Book                   +");
					System.out.println("+ 5. Borrow Book                   +");
					System.out.println("+ 6. Search Borrowed Books         +");
					System.out.println("+ 7. Return Book                   +");
					System.out.println("+ 8. Search Returned Books         +");
					System.out.println("+ 9. Deactivated Books             +");
					System.out.println("+ 10. Log Out                      +");
					System.out.println("+                                  +");
					System.out.println("++++++++++++++++++++++++++++++++++++");


				        System.out.print("Enter your choice: ");
				        choice1 = in.nextInt();
				    } catch (Exception e) {
				    }
				} else{
					if(!signUp || check==false){
				        System.out.println("Invalid Username or Password!");
					}			    
				}

                 //CHOOSING

				if(loginSuccess==true){
				switch(choice1){


					case 1:
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("++++++++++++++++++++++");
						System.out.println("+    Add Student     +");
						System.out.println("++++++++++++++++++++++");

						FileWriter myWriterIDDSSS = new FileWriter("C:/FinalSystem/studentsIDSSSSSS.txt",true);

						LocalDate loginTime = LocalDate.now();

						 System.out.println("---Student Information Form---");

						 in=new Scanner(System.in);

					File pangita = new File("C:/FinalSystem/studentsIDSSSSSS.txt");
					Scanner pangitaRead = new Scanner(pangita);
					String [] array = new String [9999];
					 String dataar ="";

					 
					 
					while (pangitaRead.hasNextLine()) {
					    dataar = pangitaRead.nextLine();
					    array = dataar.split(";"); 
					}
					pangitaRead.close();

				String accessID2 = "";

				do {
				    System.out.print("Enter Student ID: ");
				    accessID2 = in.nextLine();

				    if (accessID2.isBlank()) {
				        System.out.println("Please don't leave blank details.");
				        continue;
				    }

				    boolean validInput = false;

				    while (!validInput) {
				        if (dataar.contains(";" + accessID2 + "|")) {
				            System.out.println("Student ID already exists! Please enter a different Student ID.");
				            System.out.print("Enter Student ID: ");
				            accessID2 = in.nextLine();
				        } else if (!accessID2.matches("\\d+")) {
				            System.out.println("Invalid input! Please enter a numeric Student ID.");
				            System.out.print("Enter Student ID: ");
				            accessID2 = in.nextLine();
				        } else {
				            validInput = true;
				        }
				    }
				} while (accessID2.isBlank());


					


					     String fns, mns, lns;
        
				        do {
				            System.out.print("Enter First Name: ");
				            fns = in.nextLine();

				             if (fns.isBlank()) {
				                System.out.println("Please don't leave blank details.");
				            }

				        }while(fns.isBlank());

				         do {
				            System.out.print("Enter Middle Name: ");
				            mns = in.nextLine();

				             if (mns.isBlank()) {
				                System.out.println("Please don't leave blank details.");
				            }

				        }while(mns.isBlank());

				         do {
				            System.out.print("Enter Last Name: ");
				            lns = in.nextLine();

				             if (lns.isBlank()) {
				                System.out.println("Please don't leave blank details.");
				            }

				        }while(lns.isBlank());
				            
				        System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
				        System.out.println("Added Student Information Successfully.");

				        myWriterIDDSSS.write(";"+accessID2+"|");
				        myWriterIDDSSS.close();

					    records.write(accessID2+";"); 
					    records.close(); 

					    officialRecords.write(accessID2+";"+fns+";"+mns+";"+lns+";"+loginTime+"\n");
				
						officialRecords.close();
					    			
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}

						break;
					case 2:
						//ADD BOOKS
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("++++++++++++++++++");
						System.out.println("+   Add Books    +");
						System.out.println("++++++++++++++++++");

						FileWriter myWriterI = new FileWriter("C:/FinalSystem/isbn.txt",true);
						FileWriter myWriterbNames = new FileWriter("C:/FinalSystem/bnames.txt",true);

						System.out.println("---Add Books Details Form---");
						in = new Scanner(System.in);

						File libro2 = new File("C:/FinalSystem/books.txt");
						Scanner bReader2 = new Scanner(libro2);

						File libro23 = new File("C:/FinalSystem/bnames.txt");
        				Scanner bReader23= new Scanner(libro23);

						//AUTO INCREEMENT

						int latestId1=0;
						while (bReader2.hasNextLine()) {
						    String[] details78 = new String[7];
						    String data15 = bReader2.nextLine();
						    details78 = data15.split(";");
						    if (details78.length >= 1 && !details78[0].isEmpty()) {
						        int id1 = Integer.parseInt(details78[0]);
						        if (id1 > latestId1) {
						            latestId1 = id1;
						        }
						    }
						}

							//AUTO INCREEMENT

						String ngalan="";

						while(bReader23.hasNextLine()){
							ngalan = bReader23.nextLine();

						}
						bReader23.close();

						boolean tigcheck = true;
						String bName = "";

						while (tigcheck==true) {
							do{
						    System.out.print("Enter Book Name: ");
						    bName = in.nextLine();

						    	if (bName.isBlank()) {
				                System.out.println("Please don't leave blank details.");
				            }


						}while(bName.isBlank());
						    if (ngalan.contains(";"+bName+"|")) {
						        System.out.println("Book name already exists.");					       
						    } else {
						        tigcheck = false;
						    }
						}

						//Filtering Blank Details
						String bAu, bEd, bPub;
        
				        do {
				            System.out.print("Enter Author: ");
							bAu = in.nextLine();

							if (bAu.isBlank()) {
				                System.out.println("Please don't leave blank details.");
				            }

						}while(bAu.isBlank());


						 do {
				            
				            System.out.print("Enter Edition: ");
							bEd = in.nextLine();

							if (bEd.isBlank()) {
				                System.out.println("Please don't leave blank details.");
				            }

						}while(bEd.isBlank());	

						 do {
				            
				            System.out.print("Enter Publisher: ");
							bPub = in.nextLine();

							if (bPub.isBlank()) {
				                System.out.println("Please don't leave blank details.");
				            }

						}while(bPub.isBlank());									          								  

				        //Filtering Blank Details

				        //Filtering Numeric ISBN 
						boolean oks3 = true;
						System.out.print("Enter Book ISBN: ");
						String bIs = "";

						while(oks3==true){
							do{
							bIs = in.nextLine();
							if(bIs.isBlank()){
								System.out.println("Please don't leave blank details.");
								System.out.print("Enter Book ISBN: ");
							}
						}while(bIs.isBlank());

							if(!bIs.matches("\\d+")){
								System.out.println("Contains Non Numeric Value.");
								System.out.print("Enter Book ISBN: ");	

							}else{
								oks3=false;
							}
						}

						//Filtering Numeric ISBN 

						String bCat;

						do {
				            System.out.print("Enter Category: ");
							bCat = in.nextLine();

				            if (bCat.isBlank()) {
				                System.out.println("Please don't leave blank details.");
				            }
				        } while (bCat.isBlank());

						latestId1++;

						myWriterbNames.write(";"+bName+"|");
						myWriterbNames.close();

						myWriterI.write(bIs+";");
						myWriterI.close();

						myWriter.write("000"+latestId1+";"+bName+";"+bAu+";"+bEd+";"+bPub+";"+bIs+";"+bCat+";Active\n"); 			
						myWriter.close(); 
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("Book successfully added!");
							System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						//ADD BOOKS

						//DISPLAY BOOKS
								System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						File myObj = new File("C:/FinalSystem/books.txt");
						Scanner myReader = new Scanner(myObj);
					
						System.out.printf("%-8s %-25s %-20s %-20s %-20s %-15s %-20s %-10s%n",
                   			 "Book ID", "Book Name", "Author", "Edition", "Publisher", "ISBN", "Category", "Status");
						System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");	
						while (myReader.hasNextLine()) {
							String []details = new String[7];
							String data = myReader.nextLine(); 
							details = data.split(";"); 
									 System.out.printf("%-8s %-25s %-20s %-20s %-20s %-15s %-20s %-10s%n", 
                      					  details[0], details[1], details[2], details[3], details[4], details[5], details[6], details[7]);
						}
						myReader.close();
							System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						//DISPLAY BOOKS
						
					break;

					case 3:
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("++++++++++++++++++++++");
						System.out.println("+   Add Accession    +");
						System.out.println("++++++++++++++++++++++");

						LocalDate pcTime = LocalDate.now();

						File copies = new File("C:/FinalSystem/accession.txt");
						Scanner cReader = new Scanner(copies);

						File libro = new File("C:/FinalSystem/books.txt");
						Scanner bReader = new Scanner(libro);

						
						String[] details1 = new String[3];
						String[] details12 = new String[999];
						int inc = 0;

						//AUTO INCREEMENT
						int latestId = 0;
						while (cReader.hasNextLine()) {
						    String[] details = new String[3];
						    String data = cReader.nextLine();
						    details = data.split(";");
						    if (details.length >= 1 && !details[0].isEmpty()) {
						        int id = Integer.parseInt(details[0]);
						        if (id > latestId) {
						            latestId = id;
						        }
						    }
						}

						//autoincreement	

						in = new Scanner(System.in);
						String aBid="";

						do{

						System.out.print("Enter Book ID: ");
						aBid = in.nextLine();

						if(aBid.isBlank()){
							System.out.println("Please don't leave blank details.");
						}

						}while(aBid.isBlank());

						boolean bookIdFound = false;
						String[] finder = new String[999];
						int finderIndex = 0;

						while (bReader.hasNextLine()) {
						    String data12 = bReader.nextLine();
						    details12 = data12.split(";");
						    finder[finderIndex] = details12[0];
						    finderIndex++;
						}

						for (int i = 0; i < finderIndex; i++) {
						    if (finder[i].equals(aBid)) {
						        bookIdFound = true;
						        break;
						    }
						}

						if (bookIdFound) {

							String acop2="";

						do{

						System.out.print("Number of Copies that you want to add: ");
						acop2 = in.nextLine();

						if(acop2.isBlank()){
							System.out.println("Please don't leave blank details.");
						}

						}while(acop2.isBlank());	

						int acop =Integer.parseInt(acop2);

						    for (int a = 0; a < acop; a++) {
						        latestId++;
						        myWriterA.write("0" + latestId + ";" + aBid + ";" + pcTime + ";1\n");
						    }

						    myWriterA.close();

						    System.out.println("Copies Added Successfully!");
						} else {
						    System.out.println("Book ID not Registered. Please try again.");
						}

						cReader.close();
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						break;

					case 4:
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("+++++++++++++++++++++");
						System.out.println("+   Search Books    +");
						System.out.println("+++++++++++++++++++++");


						boolean unfound12=false;
						File myObj1121 = new File("C:/FinalSystem/books.txt"); 
						Scanner myReader1121 = new Scanner(myObj1121);

						in = new Scanner(System.in);

						String search121 ="";

						do{

							System.out.print("Enter Book ID or any key related to the book: ");
							search121 = in.nextLine();

							if(search121.isBlank()){
								System.out.println("Please don't leave blank details.");
							}
						}while(search121.isBlank());
						
						System.out.println("Search result for "+search121);


						//DISLPAY  BOOKS

							System.out.println("Name                Author              Edition                ISBN                Category");
							System.out.println("------------------------------------------------------------------------------");

							while (myReader1121.hasNextLine()) {
							    String[] details121 = new String[7];
							    String data121 = myReader1121.nextLine();
							    details121 = data121.split(";");

							    if (data121.contains(search121)) {
							        System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", details121[1], details121[2], details121[3], details121[5], details121[6]);
							        unfound12 = true;
							    }
							}

							if(unfound12==false){
									System.out.println("");
									System.out.println("   No Books Found   ");
									System.out.println("");
								}					
							myReader1121.close();


						break;
						

					case 5:
						System.out.println("");
						System.out.println("   Borrow Books    ");
						System.out.println("");


							File listahan = new File("C:/FinalSystem/students.txt");
							Scanner list = new Scanner(listahan);

							in = new Scanner(System.in);

							String[] find = new String[999];

							boolean studentFound = false;

							while (list.hasNextLine()) {
							    String findata = list.nextLine();
							    find = findata.split(";");
							}
							list.close();



							System.out.print("Enter Student ID: ");
							String accessID = "";

							while (true) {

								do{

							    accessID = in.nextLine();

							    if(accessID.isBlank()){
								System.out.println("Please don't leave blank details.");
								System.out.print("Enter Student ID: ");
								}

								}while(accessID.isBlank());

							    if (accessID.matches("\\d+")) {
							        break;
							    } else {
							        System.out.println("Invalid input! Please enter a numeric Student ID.");
							        System.out.print("Enter Student ID: ");
							    }
							}

							//PANGITA SA STUDENT ID


							for (int k = 0; k < find.length; k++) {
							    if (find[k] == null) {
							        break;
							    }
							    if (find[k].equals(accessID)) {
							        studentFound = true;
							        break;
							    }
							}

								//PANGITA SA STUDENT ID

							if (studentFound) {
							    System.out.println("Access Granted...\nStudent ID found!");
							    // Proceed with the rest of the code
							} else {
							    System.out.println("Access Denied...\nStudent ID Not Found!");
							    break;
							}						
						
							in = new Scanner(System.in);

							LocalDate dateBorrowed = LocalDate.now();

							File myObj4 = new File("C:/FinalSystem/books.txt");
							Scanner myReader4 = new Scanner(myObj4);

							File myObj45 = new File("C:/FinalSystem/accession.txt");
							Scanner myReader45 = new Scanner(myObj45);

							//Searching

						boolean unfound8=false;
						File myObject = new File("C:/FinalSystem/book.txt"); 
						Scanner tigRead = new Scanner(myObject);

						in = new Scanner(System.in);

						String search88 ="";

						do{

							System.out.print("Enter Book ID: ");
							search88 = in.nextLine();

							if(search88.isBlank()){
								System.out.println("Please don't leave blank details.");
							}
						}while(search88.isBlank());
						

						//DISLPAY  BOOKS

							System.out.println("Book ID               Name                Author              Edition                ISBN                Category");
							System.out.println("------------------------------------------------------------------------------");
							String [] valid2 = new String [999];
							int counter3=0;
							boolean sige=true;
							while (tigRead.hasNextLine()) {
							    String[] detailsArray = new String[8];
							    String data88 = tigRead.nextLine();
							    detailsArray = data88.split(";");

							    if (search88.equalsIgnoreCase(detailsArray[0]) && detailsArray[7].equalsIgnoreCase("active")) {
							        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s%n", detailsArray[0],detailsArray[1], detailsArray[2], detailsArray[3], detailsArray[5], detailsArray[6]);
							        valid2[counter3]=detailsArray[0];
							        counter3++;
							        unfound8 = true;
							    }
							}

							if(unfound8==false){
								System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
									System.out.println("++++++++++++++++++++++");
									System.out.println("+   No Books Found   +");
									System.out.println("++++++++++++++++++++++");
									sige=false;
								}					
							tigRead.close();

							//Searching

							String search4 ="";
							if(sige==true){

							 		boolean validAccessionId2 = false;
							        while (!validAccessionId2) {
							        	do{
							            System.out.print("Please enter the Book ID of the Book as Confirmation of what your Borrowing: ");
							            search4 = in.nextLine();
							            if(search4.isBlank()){
							            	System.out.println("Please input the Book ID.");
							            }
							            }while(search4.isBlank());
							            for (String word2 : valid2) {
							                if (word2 != null && word2.equals(search4)) {
							                    validAccessionId2 = true;
							                    break;
							                }
							            }

							            if (!validAccessionId2) {
							                System.out.println("Invalid Book ID. Please try again.");
							            }
							        }
							    }


							int count = 0;
							String borrowed = "";
							String[] details44 = new String[4];
							String[] secondWords = new String[999];
							String[] valid = new String[999];
							int index = 0;

							boolean bookFound = false;
							

							while (myReader4.hasNextLine()) {
							    String[] details = myReader4.nextLine().split(";");

							    if (search4.equalsIgnoreCase(details[0])) {
							        bookFound = true;
							        System.out.println("Book Name: " + details[1]);
							        System.out.println("Author: " + details[2]);
							        System.out.println("Category: " + details[6]);
									System.out.println("Accession ID\tBook ID\t\tDate Added\tStatus");
							        while (myReader45.hasNextLine()) {
							            String data44 = myReader45.nextLine();
							            details44 = data44.split(";");

							            if (details44.length >= 4) {
							                secondWords[index] = details44[1].trim();
							                index++;


							                if (details44[1].equals(search4) && details44[3].equals("1")) {
							                    System.out.print(details44[0] + ";\t\t" + details44[1] + ";\t\t" + details44[2] + ";\t" + details44[3] + "\n");
							                    valid[count]=details44[0];
							                    count++;
							                }
							            }
							        }

							        myReader45.close();

							        if (count == 0) {
							        	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
							        System.out.println("++++++++++++++++++++++++++++++++++");
									System.out.println("+   Sorry, No Copies Available   +");
									System.out.println("++++++++++++++++++++++++++++++++++");
							            break;  // Terminate the program
							        }else{
							        	 System.out.println(count+" Copies available.");
							        }

							        boolean validAccessionId = false;
							        while (!validAccessionId) {
							        	do{
							            System.out.print("Please enter the accession ID you want to borrow: ");
							            borrowed = in.nextLine();
							            if(borrowed.isBlank()){
							            	System.out.println("Please input an accesion ID.");
							            }
							            }while(borrowed.isBlank());

							            for (String word : valid) {
							                if (word != null && word.equals(borrowed)) {
							                    validAccessionId = true;
							                    break;
							                }
							            }

							            if (!validAccessionId) {
							            	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
							                System.out.println("Invalid Accession ID. Please try again.");
							            }
							        }

							        break;
							    }
							}

							myReader4.close();

							if (!bookFound) {
							  
							} else {

							    String newStat = "Active";

							    boolean bookBorrowed = false;  // Added variable to track if the book is borrowed successfully

							    for (String word : secondWords) {
							        if (word != null && word.contains(search4) && count>0) {
							            newStat = "Deactivate";
							            bookBorrowed = true;  // Set the flag if the book is borrowed successfully
							            break;
							        }
							    }

							    if (bookBorrowed) {
							    	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
							        System.out.println("Book borrowed successfully!");
							    }

							    //GET THE VALUE OF ACCESSION


							    File myObj44 = new File("C:/FinalSystem/accession.txt");
							    Scanner myReader44 = new Scanner(myObj44);

							    ArrayList<String> prev4 = new ArrayList<String>();
							    while (myReader44.hasNextLine()) {
							        String data = myReader44.nextLine();
							        prev4.add(data);
							    }
							    myReader44.close();

							    //WRITE THE BORROWED BOOK INFO 

							    FileWriter myWriterPs44 = new FileWriter("C:/FinalSystem/borrow.txt",true);
								for (int a = 0; a < prev4.size(); a++) {
								    String[] details = prev4.get(a).split(";");
								    if (details.length >= 4 && borrowed.equals(details[0])) {
								        myWriterPs44.write(accessID+";"+borrowed + ";" + details[1] + ";" + dateBorrowed +";0000-00-00"+ ";inActive\n");
								    }
								}

								//CHANGE THE STAT IN THE ACCESSION SO THAT BORROWED BOOK WILL NOT BE DISPLAYED AGAIN

								myWriterPs44.close();

							    FileWriter myWriterPs66 = new FileWriter("C:/FinalSystem/accession.txt");
							    for (int a = 0; a < prev4.size(); a++) {
							        String[] details6 = prev4.get(a).split(";");
							        if (borrowed.equals(details6[0])) {
							            myWriterPs66.write(borrowed + ";" + details6[1] + ";" + details6[2] + ";" + newStat + "\n");
							        } else {
							            myWriterPs66.write(prev4.get(a) + "\n");
							        }
							    }


							    myWriterPs66.close();

							    loginSuccess = true;
							}



					break;

					case 6:
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("++++++++++++++++++++++++++++++");
						System.out.println("+   Search Borrowed Books    +");
						System.out.println("++++++++++++++++++++++++++++++");


						boolean unfound2=false;
						boolean sign=true;
						File myObj112 = new File("C:/FinalSystem/borrow.txt"); 
						Scanner myReader112 = new Scanner(myObj112);

						File libroSearch = new File("C:/FinalSystem/books.txt"); 
						Scanner libroRead = new Scanner(libroSearch);

						in = new Scanner(System.in);

						String search12 ="";
						do{
						System.out.print("Enter Borrowed Book Details: ");
						search12 = in.nextLine();

						if(search12.isBlank()){
							System.out.println("Please Input the Details.");
						}

						}while(search12.isBlank());

						System.out.println("Search result for "+search12);

						String[] details2 = new String[8];

						

						File hiramSearch = new File("C:/FinalSystem/borrow.txt"); 
						Scanner hiramRead = new Scanner(hiramSearch);

							String datahiram1="";

							while (hiramRead.hasNextLine()) {
						     datahiram1 = hiramRead.nextLine();
						}
						hiramRead.close();


						
						while (libroRead.hasNextLine()) {
						    String data2 = libroRead.nextLine();
						    details2 = data2.split(";");

						    if (data2.contains(search12) || datahiram1.contains(search12)) {
			            	  unfound2 = true;

						        boolean bookInfoDisplayed = false; // Flag to track if book information has been displayed

						        while (myReader112.hasNextLine()) {
						            String[] details = new String[3];
						            String data = myReader112.nextLine();
						            details = data.split(";");

						            if (details[0].equals(details[1]) || details[0].equals(details[2]) || details[0].equals(details[3]) || details2[0].equals(details[4]) && details[5].equals("2") ) {
						            	 sign=false;
						                if (!bookInfoDisplayed) {
						                	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						                    System.out.println("Book Name: " + details2[1]);
						                    System.out.println("Book Author: " + details2[2]);
						                    System.out.println("Book Category: " + details2[6]);
						                    System.out.println();
						                    System.out.println("Student ID\t\tBook Title\t\tAccession ID\t\tBook ID\t\tDate Borrowed");
						                    System.out.println("-------------------------------------------------------------------------");
						                    bookInfoDisplayed = true;
						                   
						                    System.out.println(details[0] + "\t\t\t" +details2[1] + "\t\t\t" + details[1] + "\t\t\t" + details[2] + "\t\t" + details[3]);
						                }


						            }
						        }

						        System.out.println();
						    }
						}
						libroRead.close();
						myReader112.close();


						//DISLPAY BORROWED BOOKS
								
									
																	
						//DISLPAY BORROWED BOOKS
								if(sign==true || unfound2==false){	
								System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}								
									System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
									System.out.println("+    No Borrowed Record of this Book Found!    +");
									System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
								}				

							
							if(unfound2==false){
								System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
									System.out.println("+++++++++++++++++++++++++++++++++++++++");
									System.out.println("+    Book Information Not Existing    +");
									System.out.println("+++++++++++++++++++++++++++++++++++++++");
								}					
						
								
						

						//DISLPAY BORROWED BOOKS

					
					break;

					case 7:
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("++++++++++++++++++++++");
						System.out.println("+    Return Books    +");
						System.out.println("++++++++++++++++++++++");

                            in = new Scanner(System.in);

                            LocalDate dateReturned = LocalDate.now();	

                            File borrowFile = new File("C:/FinalSystem/borrow.txt");
                            Scanner borrowReader = new Scanner(borrowFile);

                            File booksFile = new File("C:/FinalSystem/books.txt");
                            Scanner booksReader = new Scanner(booksFile);

                            String returnBookId ="";

                            do{

                            System.out.print("Enter the Book Details to the Book you want to return: ");
                            returnBookId = in.nextLine();

                            System.out.print("Please Input the Book Details: ");
							String bkd=in.nextLine();

                            	if(returnBookId.isBlank()){

						}

                        }while(returnBookId.isBlank());

                            boolean bookFound1 = false;
                            

                            while (booksReader.hasNextLine()) {
                                String[] bookDetails = new String [999];
                                String dawat = booksReader.nextLine();
                                bookDetails= dawat.split(";");

                                if (dawat.contains(returnBookId)) {
                                    bookFound1 = true;
                                    System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
                                    System.out.println("++++++++++++++++++++");
									System.out.println("+   Description    +");
									System.out.println("++++++++++++++++++++");
									System.out.println("Book ID: \t" + bookDetails[0]);
                                    System.out.println("Book Name: \t" + bookDetails[1]);
                                    System.out.println("Author: \t" + bookDetails[2]);
                                    System.out.println("Category: \t" + bookDetails[6]);
                                }
                            }


                            		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
									System.out.println("+        Book Return Successfully              +");
									System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

                            booksReader.close();

                            if (!bookFound1) {    
                            System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}                           
                                System.out.println("++++++++++++++++++++++++++++++++");
								System.out.println("+   Book Details Not Found!    +");
								System.out.println("++++++++++++++++++++++++++++++++");
                            } else {
                                ArrayList<String> borrowedRecords = new ArrayList<String>();

                                while (borrowReader.hasNextLine()) {
                                    String borrowedData = borrowReader.nextLine();
                                    String[] borrowedDetails = borrowedData.split(";");

                                    if (borrowedDetails.length >= 4  && borrowedDetails[5].equals("2")) {
                                        borrowedRecords.add(borrowedData);
                                    }
                                }

                                borrowReader.close();

                                if (borrowedRecords.isEmpty()) {	
                                System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}      
                                } else {
                                    System.out.println("----Available Borrowed Records of the Book---");

									System.out.println("Student ID\t\tAccession ID\t\tBook ID\t\tDate Borrowed\t\tStatus");
                                    for (String borrowedRecord : borrowedRecords) {
                                        String[] details = borrowedRecord.split(";");

                                        System.out.println(details[0] +"\t\t\t" + details[1]+ "\t\t\t"+details[2] + "\t\t"+details[3] +"\t\t" + details[4]);
                                    }

                                    boolean validAccessionId = false;
                                    String returnAccessionId = "";

                                    while (!validAccessionId) {
                                    	do{
                                        System.out.print("Please enter the Accession ID you want to return: ");
                                        returnAccessionId = in.nextLine();

                                        if(returnAccessionId.isBlank()){
											System.out.println("Please enter accession ID.");
										}

                                    }while(returnAccessionId.isBlank());
                                        for (String borrowedRecord : borrowedRecords) {
                                            String[] details = borrowedRecord.split(";");
                                            if (returnAccessionId.equals(details[1])) {
                                                validAccessionId = true;
                                                break;
                                            }
                                        }

                                        if (!validAccessionId) {
                                            System.out.println("Invalid Accession ID. Please try again.");
                                        }
                                    }

										File balik = new File("C:/FinalSystem/borrow.txt");
										Scanner myReaderbalik = new Scanner(balik);

										ArrayList<String> prev4 = new ArrayList<String>();
										while (myReaderbalik.hasNextLine()) {
										    String data = myReaderbalik.nextLine();
										    prev4.add(data);
										}
										myReaderbalik.close();

										FileWriter balikWriter = new FileWriter("C:/FinalSystem/borrow.txt");
										for (int a = 0; a < prev4.size(); a++) {
										    String[] details = prev4.get(a).split(";");
										    if (details.length >= 4 && returnAccessionId.equals(details[1])) {
										        balikWriter.write(details[0] + ";" + details[1] + ";" + details[2] + ";" + details[3] + ";" + dateReturned + ";1\n");
										    } else {
										        balikWriter.write(prev4.get(a) + "\n");
										    }
										}

										balikWriter.close();


										ArrayList<String> prev47 = new ArrayList<String>();
										Scanner myReaderbalik1 = new Scanner(new File("C:/FinalSystem/accession.txt"));

										while (myReaderbalik1.hasNextLine()) {
										    String data1 = myReaderbalik1.nextLine();
										    prev47.add(data1);
										}
										myReaderbalik1.close();

										FileWriter myWriterPs66 = new FileWriter("C:/FinalSystem/accession.txt");
										for (int a = 0; a < prev47.size(); a++) {
										    String[] details6 = prev47.get(a).split(";");
										    if (returnAccessionId.equals(details6[1])) {
										        myWriterPs66.write(details6[0] + ";" + details6[1] + ";" + details6[2] + ";" + "1\n");
										    } else {
										        myWriterPs66.write(prev47.get(a) + "\n");
										    }
										}
										myWriterPs66.close();

										System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
                                    System.out.println("Book returned successfully!");
                 
                                }
                            }

						
					break;

					case 8:
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("++++++++++++++++++++++++++++++");
						System.out.println("+   Search Returned Books    +");
						System.out.println("++++++++++++++++++++++++++++++");


							boolean unfound3=false;
						boolean sign2=true;
						File myObj1122 = new File("C:/FinalSystem/borrow.txt"); 
						Scanner myReader1122 = new Scanner(myObj1122);

						File libroSearch2 = new File("C:/FinalSystem/books.txt"); 
						Scanner libroRead2 = new Scanner(libroSearch2);

						in = new Scanner(System.in);
						String searchni = "";
						do{
						System.out.print("Enter Returned Book Details: ");
						searchni = in.nextLine();

						if(searchni.isBlank()){
							System.out.println("Please Enter Details.");
						}

						}while(searchni.isBlank());
						System.out.println("Search result for "+searchni);

						
						String[] details3 = new String[8];
						while (libroRead2.hasNextLine()) {
						    String data2 = libroRead2.nextLine();
						    details3 = data2.split(";");

						    if (data2.contains(searchni)) {
						        unfound3 = true;
						        System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						        System.out.println("Book Name: " + details3[1]);
						        System.out.println("Book Author: " + details3[2]);
						        System.out.println("Book Category: " + details3[6]);
						      
						       
						        while (myReader1122.hasNextLine()) {
						        	  System.out.println("Student ID\t\tAccession ID\t\tBook ID\t\tDate Borrowed\t\tDate Returned");
						        System.out.println("----------------------------------------------------------------------------------------------------------");

						            String[] details = new String[3];
						            String data = myReader1122.nextLine();
						            details = data.split(";");
						            if (details3[0].equals(details[0]) || details3[0].equals(details[1]) || details3[0].equals(details[2]) || details3[0].equals(details[3]) || details3[0].equals(details[4]) || details[5].equals("1")) {
						                System.out.println(details[0] + "\t\t\t" + details[1] + "\t\t\t" + details[2] + "\t\t" + details[3] + "\t\t" + details[4]);
						                sign2 = false;
						            }
						        }

						        if (sign2 && unfound3) {
						        	System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
						            System.out.println("+    No Returned Record of this Book Found!    +");
						            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
						        }
						    }
						}

						if (!unfound3) {
							System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						    System.out.println("+++++++++++++++++++++++++++++++++++++++");
						    System.out.println("+    Book Information Not Existing    +");
						    System.out.println("+++++++++++++++++++++++++++++++++++++++");
						}

						libroRead2.close();
						myReader1122.close();



						//DISLPAY RETURNED BOOKS


					   break;

					   case 9:
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
									}catch (InterruptedException ex){	
								}
						System.out.println("++++++++++++++++++++++++++++++");
						System.out.println("+       Deactivate Books     +");
						System.out.println("++++++++++++++++++++++++++++++");
						in = new Scanner(System.in);
						boolean found = true;
						File myObj6 = new File("C:/FinalSystem/books.txt");
						Scanner myReader6 = new Scanner(myObj6);
						String search6 = "";
						
							
								System.out.print("\nEnter Book ID: ");
								search6 = in.nextLine();
								
						String stat = "Inactive";
						while (myReader6.hasNextLine()) {
							String[] details = new String[8];
							String data = myReader6.nextLine();
							details = data.split(";");
							if (search6.equalsIgnoreCase(details[0])) {
								System.out.println("Student ID: " + details[0]);
								System.out.println("Accession ID: " + details[1]);
								System.out.println("Book ID: " + details[2]);
								System.out.println("Date Borrow: " + details[3]);
								System.out.println("Date Return: " + details[4]);
								System.out.println("Status: " + details[7]);
								found=false;
								if (details[7].equals("Active")) {
									stat = "Active";
								}
								System.out.println("Status: " + stat);
							}
						}
						String newStat = "0";
						myReader6.close();
						if(!found){
							if (stat.equals("Active")) {
								newStat = "Deactivate";
								System.out.println("Book " + search6 + " has been deactivated successfully");
							} 
						}else{
							System.out.println("Book Not Found.");
						}
						

						File myObj63 = new File("C:/FinalSystem/books.txt");
						Scanner myReader63 = new Scanner(myObj63);

						ArrayList<String> prev6 = new ArrayList<String>();
						while (myReader63.hasNextLine()) {
							String data = myReader63.nextLine();
							prev6.add(data);
						}
						myReader63.close();

						FileWriter myWriterPs6 = new FileWriter("C:/FinalSystem/books.txt");
						for (int a = 0; a < prev6.size(); a++) {
							String[] details = new String[8];
							details = prev6.get(a).split(";");
							if (search6.equalsIgnoreCase(details[0])) {
								myWriterPs6.write(details[0] + ";" + details[1] + ";" + details[2] + ";"+ details[3] + ";"+  details[4]+ ";"+ ";"+  details[7]+ ";"+ newStat + "\n");
							} else {
								myWriterPs6.write(prev6.get(a) + "\n");
							}
						}
						myWriterPs6.close();
						loginSuccess = true;

						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(3000);
									}catch (InterruptedException ex){	
								}
				
					break;

					
					case 10:

					
						loginSuccess=false;

						
					break;

					default:
						System.out.println("\nLoading................\n\n");
							 	try{
									Thread.sleep(1000);
								}catch (InterruptedException ex){	
								}
						System.out.println("Invalid choice!");
					break;
				}
			}
							  
			}while(true==true);
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
