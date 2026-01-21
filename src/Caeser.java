public class Caeser {

    public static String encrypt(String word, int key) {

        if(key < 1 || key > 25) return null;

        StringBuilder encryptedWord = new StringBuilder();

        if (!word.isEmpty()) {
            for (char c : word.toCharArray()) {
                if (c != ' '){

                    if((int) c >= 97){
                        int shiftedCharCode = encryptChar(c, key, 97);
                        encryptedWord.append((char) shiftedCharCode);
                    }else if ((int) c <= 90){
                        int shiftedCharCode = encryptChar(c, key, 65);
                        encryptedWord.append((char) shiftedCharCode);
                    }

                } else encryptedWord.append(' ');
            }
        }
        return encryptedWord.toString();
    }

    public static String decrypt(String word, int key) {

        if(key < 1 || key > 25) return null;

        StringBuilder decryptedWord = new StringBuilder();

        if (!word.isEmpty()) {
            for (char c : word.toCharArray()) {

                if(c != ' '){
                    if((int) c >= 97){
                        int shiftedCharCode = c - key;

                        if(shiftedCharCode < 97){
                            shiftedCharCode = shiftedCharCode + 26;
                        }

                        decryptedWord.append((char) shiftedCharCode);
                    }else if ((int) c <= 90){
                        int shiftedCharCode = decryptChar(c, key, 65);

                        if(shiftedCharCode < 65){
                            shiftedCharCode = shiftedCharCode + 26;
                        }

                        decryptedWord.append((char) shiftedCharCode);
                    }
                }else decryptedWord.append(' ');

            }
        }
        return decryptedWord.toString();
    }

    public static char encryptChar(char c, int key, int shift) {
        return (char) ((((c - shift) + key) % 26) + shift);
    }

    public static char decryptChar(char c, int key, int shift) {
        return encryptChar(c, 26 - key, shift);
    }


}
