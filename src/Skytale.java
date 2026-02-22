public class Skytale {


    public static String encrypt(String word, int faces) {

        int len = word.length();
        char[] result = new char[len];

        int pos = 0;

        for (int i = 0; i < faces; i++) {
            for (int j = 0; j < len - i; j += faces) {
                result[j + i] = word.charAt(pos++);
            }
        }

        return new String(result);
    }

    public static String decrypt(String word, int faces) {

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < faces; i++) {
            for (int j = 0; j < word.length() - i; j += faces) {
                temp.append(word.charAt(j + i));
            }
        }

        return temp.toString();
    }
}