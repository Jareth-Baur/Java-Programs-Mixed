public class Encryption {

    public Encryption() {
    }

    public String encrypt(String text) {
        char[] chars = text.toCharArray();
        String encryptedText = "";
        for (char c : chars) {
            encryptedText += (c += 6);
        }
        return "The encrypted value is: " + encryptedText;
    }

    public boolean isFirstLetterConsonant(String string) {
        if ((string.charAt(0) + "").matches("[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]")) {
            return true;
        } else {
            return false;
        }
    }

    public int countConsonant(String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) + "").matches("[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]")) {
                counter++;
            }
        }
        return counter;
    }

    public int countEvenNumber(String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) + "").matches("[1234567890]")) {
                if (string.charAt(i) % 2 == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
