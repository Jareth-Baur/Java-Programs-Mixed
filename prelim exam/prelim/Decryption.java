
public class Decryption {
    final int KEY = 6;

    public String decrypt(String text) {
        char[] chars = text.toCharArray();
        String decryptedText = "";
        for (char c : chars) {
            c -= KEY;
            decryptedText += c;
        }
        return decryptedText + " has been decrypted.";
    }
}
