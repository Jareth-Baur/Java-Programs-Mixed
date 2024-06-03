package samples;

import java.util.*;

public class Main {
    public static void main(String[] agrs) {
        Scanner ah = new Scanner(System.in);

        int ind = 0, v = 0, length2 = 0, vcount = 0, ccount = 0;
        boolean numero = false;
        String vow = "aeiouAEIOU", con = "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz", value = "";

        do {
            System.out.print("Enter Length: ");
            String length = ah.nextLine();
            try {
                length2 = Integer.parseInt(length);
                numero = true;
            } catch (Exception pre1) {
                numero = false;
            }
        } while (numero == false || length2 <= 0);

        String[] num = new String[length2];
        int[] vowt = new int[length2];
        int[] cont = new int[length2];
        int count = 0;
        for (int a = 0; a < length2; a++) {
            boolean heh = false;
            do {
                ah = new Scanner(System.in);
                System.out.print("Enter Value: ");
                value = ah.nextLine();

                if ((value.charAt(0) + "").matches("[aeiou]")) {
                    heh = true;
                } else {
                    heh = false;
                }

                for (int i = 0; i < value.length(); i++) {
                    if (String.valueOf(value.charAt(i)).matches(vow)) {
                        count++;
                    }
                }

            } while (heh == false || count % 2 != 0);
            do {
                ah = new Scanner(System.in);
                System.out.print("Input Index: ");

                try {
                    ind = (int) ah.nextInt();
                    numero = true;
                } catch (Exception pre1) {
                    numero = false;
                }
            } while (ind < 0 || ind >= length2 || num[ind] != null);
            num[ind] = value;
            vcount++;
            ccount++;
            System.out.println(Arrays.toString(num));
            System.out.println(Arrays.toString(vowt));
            System.out.println(Arrays.toString(cont));
        }
    }

    // private static boolean isFirstLetterVowel(String word) {
    // word.toLowerCase();
    // if (String.valueOf(word.charAt(0)).matches("[aeiou]")) {
    // return true;
    // } else {
    // return false;
    // }
    // }

    // private static int countVowel(String word) {
    // word.toLowerCase();
    // int vowelCount = 0;
    // for (int i = 0; i < word.length(); i++) {
    // if (String.valueOf(word.charAt(i)).matches("[aeiou]")) {
    // vowelCount++;
    // }
    // }
    // return vowelCount;
    // }
}