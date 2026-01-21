public class Vigenere {

    public static String encrypt (String word, String key) {
        key = key.toUpperCase();
        word = word.toUpperCase();
        StringBuilder encryptedWord = new StringBuilder();
        int i = 0;
        for(char c : word.toCharArray()){
                if(c >= 65 && c <= 90){
                    int k = (key.charAt(i) - 65) % 26;
                    encryptedWord.append((Caeser.decryptChar(c, k, 65)));
                    i = (i + 1) % (key.length());
                }else {
                    encryptedWord.append(c);
                }
        }
        return encryptedWord.toString();
    }

    public static String decrypt (String word, String key) {
        key = key.toUpperCase();
        word = word.toUpperCase();
        StringBuilder encryptedWord = new StringBuilder();
        int i = 0;

        for(char c : word.toCharArray()){

            if(c >= 65 && c <= 90){
                int k =  (key.charAt(i) - 65) % 26;

                int calcK = Caeser.decryptChar(c, k, 65);
                if(calcK < 65){
                    calcK = calcK + 26;
                }
                encryptedWord.append((char) calcK);
                i = (i + 1) % (key.length());
            }else {
                encryptedWord.append(c);
            }

        }

        return encryptedWord.toString();
    }

}
