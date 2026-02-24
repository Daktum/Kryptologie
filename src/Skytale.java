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

        if(false) {
            String geheim = "";

            int windungen = word.length() / faces;

            for (int i = 0; i < windungen; i++) {
                for (int j = i; j < word.length(); j += windungen) {
                    geheim = geheim + word.charAt(j);
                }
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