import java.util.Dictionary;
import java.util.Hashtable;

public class MonoSubsti {

    public static String encrypt(String word, String key) {

        StringBuilder encryptedWord = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (c >= 65 && c <= 90) {
                encryptedWord.append(key.charAt(c - 65));
            } else {
                encryptedWord.append(c);
            }
        }
        return encryptedWord.toString();
    }

    public static String decrypt(String word, String key) {
        StringBuilder decryptedWord = new StringBuilder();

        word = word.toUpperCase();

        for (char c : word.toCharArray()) {
            if (c >= 65 && c <= 90) {
                decryptedWord.append((char) (key.indexOf(c) + 65));
            } else {
                decryptedWord.append(c);
            }
        }
        return decryptedWord.toString();
    }

    public static String calcKey(String key) {
        if(key.isEmpty()) return key;

        key = key.toUpperCase();

        char[] charArray = key.toCharArray();
        StringBuilder sTemp = new StringBuilder();

        for (char c : charArray) {
            if (c >= 65 && c <= 90) {
                if (sTemp.toString().indexOf(c) < 0) {
                    sTemp.append(c);
                }
            }
        }
        key = sTemp.toString();

        char end = key.charAt(key.length()-1);

        StringBuilder keyBuilder = new StringBuilder(key);
        for(int i = 1; i <= 26; i++) {

            if(keyBuilder.toString().indexOf((char) (end + i)) < 0){
                if(end + i <= 90){
                    keyBuilder.append((char) (end + i));
                }else{
                    if(keyBuilder.toString().indexOf((char) (end + i -26)) < 0){
                        keyBuilder.append((char) ((end + i) - 26));
                    }
                }
            }


        }
        key = keyBuilder.toString();

        return key;
    }

    public static Dictionary<Character, Integer> countChars(String word) {
        StringBuilder s = new StringBuilder();

        Dictionary<Character, Integer> charCounts = new Hashtable<>();

        for (char c : word.toCharArray()) {
            int i = 0;

            if (s.toString().indexOf(c) < 0) {
                for (char b : word.toCharArray()) {
                    if (b == c) {
                        i++;
                    }
                }
                s.append(c);
                charCounts.put(c, i);
            }
        }
        return charCounts;
    }

}
