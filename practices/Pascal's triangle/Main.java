import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        int input = scanner.nextInt();

        System.out.println(generate(input));
        scanner.close();
    }
    private static String generate(int rows){
        if (rows==1) {
            return Arrays.toString(new int[]{1});
        }else if(rows==2){
            return Arrays.deepToString(new int[][]{{1},{1,1}});
        }
        return Arrays.toString(new int[]{1});
    }
}
