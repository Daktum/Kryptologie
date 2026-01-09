public class Caesar {


    public static String encrypt(String word, int key) {
        StringBuilder encryptedWord = new StringBuilder();

        if (!word.isEmpty()) {
            for (char c : word.toCharArray()) {
                if (c != ' '){

                    if((int) c >= 97){
                        int shiftedCharCode = (((c - 97) + key) % 26) + 97;
                        encryptedWord.append((char) shiftedCharCode);
                    }else if ((int) c <= 90){
                        int shiftedCharCode = (((c - 65) + key) % 26) + 65;
                        encryptedWord.append((char) shiftedCharCode);
                    }

                } else encryptedWord.append(' ');
            }
        }
        return encryptedWord.toString();
    }

    public static String decrypt(String word, int key) {
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
                        int shiftedCharCode = (((c - 65) - key) % 26) + 65;

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

    public static void main(String[] args) {
        int key = 3;
        String word = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(encrypt(word, key));

        word = encrypt(word, key);

        System.out.println(decrypt(word, key));
    }

}