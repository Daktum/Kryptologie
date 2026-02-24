public class Caeser {

    public static String encrypt(String word, int key) {
        if(key < 1 || key > 25) return null;
        StringBuilder encryptedWord = new StringBuilder();
        if (!word.isEmpty()) {
            for (char c : word.toCharArray()) {
                encryptedWord.append(encryptChar(c, key));
            }
        }
        return encryptedWord.toString();
    }

    public static String decrypt(String word, int key) {
        if (key < 1 || key > 25) return null;
        StringBuilder decryptedWord = new StringBuilder();
        if (!word.isEmpty()) {
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    decryptedWord.append(decryptChar(c, key));
                }
            }
        }
        
        return decryptedWord.toString();
    }

    public static char encryptChar(char c, int key) {
        int shiftedCharCode = 32;
        if (Character.isLetter(c)) {
            if ((int) c >= 97) {
                shiftedCharCode = (char) ((((c - 97) + key) % 26) + 97);
                if(shiftedCharCode < 97){
                    shiftedCharCode = shiftedCharCode + 26;
                }
            } else if ((int) c <= 90) {
                shiftedCharCode = (char) ((((c - 65) + key) % 26) + 65);
                if(shiftedCharCode < 65){
                    shiftedCharCode = shiftedCharCode + 26;
                }
            }
        }
        return (char) shiftedCharCode;
    }

    public static char decryptChar(char c, int key) {
        return encryptChar(c, 26 - key);
    }


}
