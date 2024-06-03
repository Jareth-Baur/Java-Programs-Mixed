import java.util.Scanner;

public class Scratch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = " ";
        int key;

        // ge initialize ang values para di mag default
        String name = "";
        String text = "";
        String word = "";

        char[] chars = text.toCharArray();

        // mangayo ug input sa user saiyang full name
        System.out.print("Enter first name: ");
        name = sc.nextLine();
        System.out.print("Enter middle name:");
        String mname = sc.nextLine();
        System.out.print("Enter last name: ");
        String lname = sc.nextLine();

        sc = new Scanner(System.in);

        // mangayo ug input sa user para sa message na iyang e encrypt
        System.out.print("input message to encrypt: ");
        String messageToEncrypt = sc.nextLine();
        key = messageToEncrypt.length(); // mo calculate sa katas on sa message na e encrypt

        // mo display sa encrypted message
        String encryptedMessage = encrypt(messageToEncrypt, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        // mo display sa decrypted message
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    // mo encrypt sa message, duha ka parameters kay ang message ug ang length() sa message
    public static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            // Encrypt uppercase letters
            if (Character.isUpperCase(c)) {
                char encryptedChar = (char) ((c + key - 65) % 26 + 65);
                encrypted.append(encryptedChar);
            }
            // Encrypt lowercase letters
            else if (Character.isLowerCase(c)) {
                char encryptedChar = (char) ((c + key - 97) % 26 + 97);
                encrypted.append(encryptedChar);
            }
            // Encrypt numbers and characters
            else {
                char encryptedChar = (char) ((c + key - 32) % 94 + 32);
                encrypted.append(encryptedChar);
            }
        }
        return encrypted.toString();
    }

    // mo decrypt sa message, duha ka parameters kay ang message ug ang length() sa message
    public static String decrypt(String message, int key) {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            // Decrypt uppercase letters
            if (Character.isUpperCase(c)) {
                char decryptedChar = (char) ((c - key - 65 + 26) % 26 + 65);
                decrypted.append(decryptedChar);
            }
            // Decrypt lowercase letters
            else if (Character.isLowerCase(c)) {
                char decryptedChar = (char) ((c - key - 97 + 26) % 26 + 97);
                decrypted.append(decryptedChar);
            }
            // Decrypt numbers and characters
            else {
                char decryptedChar = (char) ((c - key - 32 + 94) % 94 + 32);
                decrypted.append(decryptedChar);
            }
        }
        return decrypted.toString();
    }
}