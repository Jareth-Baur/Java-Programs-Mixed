
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Encryption e = new Encryption();
        Decryption d = new Decryption();
        Encryption_Decryption ed = new Encryption_Decryption();
        String text = "This is a sample text :) ";
        System.out.print("Enter message to encrypt: ");
        String en = scan.nextLine();
        System.out.println(e.encrypt(en));
        System.out.print("Enter message to decrypt: ");
        String de = scan.nextLine();
        System.out.println(d.decrypt(de));
        scan.close();
        System.out.println("---------------------------------");
        System.out.println("Plain Text: " + text);
        System.out.println("Encrypted Text: " + ed.encrypt(text));
        String enc = ed.encrypt(text);
        System.out.println("Decrypted Text: " + ed.decrypt(enc));
    }
}