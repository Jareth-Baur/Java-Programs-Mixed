public class Encryption {
    Encryption() {
    }

    public String encrypt(String input) {
        String encryptedValue = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            c += 5;
            encryptedValue += c;
        }
        return "The encrypted value is: " + encryptedValue;
    }

    public int countOddNumbers(String input) {
        int count = 0;
        for (int index = 0; index < input.length(); index++) {
            try {
                int i = Integer.parseInt(input.charAt(index) + "");
                if (i % 2 == 1) {
                    count++;
                }
            } catch (Exception e) {
            }
        }
        return count;
    }

    public int countEvenNumbers(String input) {
        int count = 0;
        for (int index = 0; index < input.length(); index++) {
            try {
                int i = Integer.parseInt(input.charAt(index) + "");
                if (i % 2 == 0) {
                    count++;
                }
            } catch (Exception e) {
            }
        }
        return count;
    }

    public int countVowel(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) + "").matches("[aeiouAEIOU]")) {
                count++;
            }
        }
        return count;
    }

    public boolean containsSpecialCharacters(String input) {
        return !input.matches("[a-zA-Z 0123456789]+");
    }

    public boolean containsComma(String input) {
        String comma = ",";
        return input.matches("(.*)" + comma + "(.*)");

    }
}