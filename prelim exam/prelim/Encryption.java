
public class Encryption {
    final int KEY = 6;

    public String encrypt(String text) {
        char[] chars = text.toCharArray();
        String encryptedText = "";
        for (char c : chars) {
            c += KEY;
            encryptedText += c;
        }
        return encryptedText + " has been encrypted.";
    }
}
