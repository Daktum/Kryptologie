import java.util.ArrayList;

public class Vigenere {

    public static String encrypt (String word, String key) {
        key = key.toUpperCase();
        StringBuilder encryptedWord = new StringBuilder();
        int i = 0;
        for(char c : word.toCharArray()){
            if(Character.isLetter(c)){
                int p = c - 'A';
                int k = key.charAt(i) - 'A';

                int encryptedChar = (p + k) % 26;

                encryptedWord.append((char) (encryptedChar + 'A'));

                i = (i + 1) % key.length();

            }else {
                encryptedWord.append(c);
            }
        }
        return encryptedWord.toString();
    }

    public static String decrypt (String word, String key) {

        if(key.isEmpty()){
            ArrayList<Integer> sub =  Kasiski.findRepeatedSequenceDistances(word);

            int wordLength = Kasiski.keyWordLength(sub);

            key = Kasiski.frequencyAnalysis(word, wordLength);
        }

        key = key.toUpperCase();
        StringBuilder encryptedWord = new StringBuilder();
        int i = 0;

        for(char c : word.toCharArray()){
            if(Character.isLetter(c)){
                int k =  (key.charAt(i) - 65) % 26;
                int calcK = Caesar.decryptChar(c, k);
                encryptedWord.append((char) calcK);
                i = (i + 1) % (key.length());
            }else {
                encryptedWord.append(c);
            }
        }
        return encryptedWord.toString();
    }

}