import java.util.*;
public class Triangles{
	public static void main (String[] Jareth){
		Scanner SC = new Scanner(System.in);

		int triangles = 0,row = 0,trianglez = 6,triangle5 = 5;
		int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,ab;

		System.out.println("Please input number from 1-7 to convert to triangles: ");
		System.out.println();
		System.out.println("1 = Left upper Triangle");
	    System.out.println("2 = Right upper Triangle");
	    System.out.println("3 = Left bottom Triangle");
	    System.out.println("4 = Right bottom  Triangle");
	    System.out.println("5 = all upper Triangles");
	    System.out.println("6 = all bottom Triangles");
	    System.out.println("7 = All Triangles");
		triangles = SC.nextInt();
		System.out.print("Please Input Size of Triangle: ");
		row = SC.nextInt();
		switch(triangles){
			case 1:
			System.out.println("Left Top Triangle");
			System.out.println();
			for(a=row; a>=1; a--){
				for(b=1; b<=row; b++){
					if(a<=b){
						System.out.print("*");
					}else{
						System.out.print(" ");
						}
				}
				System.out.println();
			}
				break;
			case 2:
			System.out.println("Right Top Triangle");
			System.out.println();
			for(c=1; c<=row; c++){
				for(d=1; d<=c; d++){
					System.out.print("*");
				}
				System.out.println();
			}
				break;
			case 3:
			System.out.println("Left Bottom Triangle");
			System.out.println();
			for(e=1; e<=row; e++){
				for(f=1; f<=row; f++){
					if(f<e){
						System.out.print(" ");
					}else{
						System.out.print("*");
					}
				}
				System.out.println();
			}
				break;
			case 4:
			System.out.println("Right Bottom Triangle");
			System.out.println();
			for(g=row; g>=0; g--){
				for(h=0; h<=row; h++){
					if(g<=h){
						System.out.print(" ");
					}else{
						System.out.print("*");
					}
				}
				System.out.println();
			}
				break;
			case 5:
			System.out.println("All Upper Triangles Triangle");
			System.out.println();
			for (i=1; i<=row; i++){
	        	for(j = i; j <=row; j++){
	              	System.out.print(" ");
	        	}
	        	for(k=1; k<=i; k++){
	        		System.out.print("*");
	        	}
	       		for(l=1; l<=1; l++){
	        		System.out.print(" ");
	       		}    	       
	      		for(m=1; m<=i; m++){
	           		System.out.print("*");
	        	}
	        	System.out.println();
			}
	        System.out.println();
				break;
			case 6:
			System.out.println("All Bottom Triangles");
			System.out.println();
			for(n=1; n<=row; n++){
	    		for(o = 1; o <= n; o++){
	            	System.out.print(" ");
	            }
	    		for(p=n; p <= row; p++){
	            	System.out.print("*");
	            }
	            for(q=1; q<=1; q++){
	        	  System.out.print(" ");
	    		}    	             
				for(r=n; r<=row; r++){
	        		System.out.print("*");
	        	}
	            System.out.println();
	    	}                            
	        System.out.println();
				break;
			case 7:
			System.out.println("All Triangles");
			System.out.println();
			for(s = 1; s<=row; s++){
	        	for(t=s; t<=row; t++){
	            	System.out.print(" ");
	        	}     
	        	for(u = 1; u <= s; u++){
	        		System.out.print("*");
	        	}
	    		for(v = 1; v <= 1; v++){
	        	  	System.out.print("   ");
	        	}    	       
				for(w = 1; w <=s; w++){
					System.out.print("*");
	        	}
	        	System.out.println();
			}
	        System.out.println();	        
			for(x=1; x<=row; x++){
	       		for(y=1; y<=x; y++){
	            	System.out.print(" ");
	            }
	       		for(v=x; v<=row; v++){
	            	System.out.print("*");
	            }
	        	for(z=1; z<=1; z++){
	        		System.out.print("   ");
	        	}    	             
	       		for(ab=x; ab<=row; ab++){
	              	System.out.print("*");
	            }
	            System.out.println();
			}
				break;
			default:
			System.out.print(triangles+" Invalid number!");
				break;
		}
	}
}