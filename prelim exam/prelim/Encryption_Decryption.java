
public class Encryption_Decryption {
    final int KEY = 6;

    public String encrypt(String text) {
        char[] chars = text.toCharArray();
        String encryptedText = "";
        for (char c : chars) {
            c += KEY;
            encryptedText += c;
        }
        return encryptedText;
    }

    public String decrypt(String text) {
        char[] chars = text.toCharArray();
        String decryptedText = "";
        for (char c : chars) {
            c -= KEY;
            decryptedText += c;
        }
        return decryptedText;
    }
}
