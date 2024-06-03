import java.util.*;
public class MultiDimeArray {
	public static void main (String[] args) {
		
		int[][][] array = new int[3][3][3];
		System.out.print("{");
		for (int i=0; i<array.length; i++) {
			System.out.print("\t{ ");
			for (int j=0; j<array[i].length; j++) {
				if (j==0)	System.out.print("\t{ ");
				else 	System.out.print("{ ");
				for (int k=0; k<array[i][j].length; k++) {
					array[i][j][k] = (int)(Math.random()*99+1);
					System.out.print(array[i][j][k]+", ");
				}
				if (j!=2)	System.out.print("},");
				else System.out.print("}\t");
			}
			if (i!=2)	System.out.println(" }, ");
			else 	System.out.print(" }\t");
		}
		System.out.print("}");
	}
}