import java.util.*;
	public class DisplayVowels{
		public static void main (String []manch){
			Scanner Manching=new Scanner (System.in);

		for (int ab=0; ab<1; ab++){ 

			System.out.print("Please enter your name: ");
				String name=Manching.nextLine();

				String vowels="";
				int count=0;
				int cons=0, cons2=0;
				int space=0;
				int diff=0;


				for (int a=0; a<name.length(); a++){
					if (name.charAt(a)=='a' || name.charAt(a)=='A'){
						vowels+=name.charAt(a)+",";
						count++;
						cons=name.length()-count;

					} else if (name.charAt(a)=='e' || name.charAt(a)=='E'){
						vowels+=name.charAt(a)+",";
						count++;
						cons=name.length()-count;

					} else if (name.charAt(a)=='i' || name.charAt(a)=='I'){
						vowels+=name.charAt(a)+",";
						count++;
						cons=name.length()-count;

					} else if (name.charAt(a)=='o' || name.charAt(a)=='O'){
						vowels+=name.charAt(a)+",";
						count++;
						cons=name.length()-count;


					} else if (name.charAt(a)=='u' || name.charAt(a)=='U'){
						vowels+=name.charAt(a)+",";
						count++;
						cons=name.length()-count;

					} else if (name.charAt(a)==' '){
						space++;
					}
				}
				cons2=cons-space;
				diff=count-cons2;
					
				System.out.println (vowels);
				System.out.println ("Number of vowels: "+count);
				System.out.println ("Number of consonant: "+cons2);
				System.out.println("Difference: "+diff);
				

		System.out.println("Do you want to try another name? ");
		System.out.println("Y=yes and N=no");
			String ans=Manching.nextLine();

			if (ans.equalsIgnoreCase("Y")){
				ab--;
			}
		}
	}
}