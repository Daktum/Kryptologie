import java.util.Locale;

public class MonoSubsti {

    public static void main(String[] args) {

        //String key = "NOFRETUVWXYZABCDGHIJKLMNPQ";
        //String key = "DUMGELAFNOPQRSTVWXYZBCHIJK";
        String key =   "DOLYZABCEFGHIJKMNPQRSTUVWX";

        String wordToEncrypt = "DIE SCHWALBE HAT UNTER FOLTER ALLES VERRATEN STOP SOFORTIGER ABBRUCH VON OPERATION KLEOPATRA";
        //String word = "GDY HENSLDYY GDY LXDB HEUEX QEEXZE CEXFEEXZE NFXE QEUEXHEXZE";
        String wordToDecrypt = "ZQ EQR SJQ BZHSJBZJ YZJ SQ MPDZQEYZJRZJ YSPLO ZEJZJ SJQZPZP GHKJZ XS ZPQZRXZJ";



        String encryptedWord = encrypt(wordToEncrypt, key);

        String decryptedWord = decrypt(wordToDecrypt, key);

        System.out.println("Encrypt:" + encryptedWord);
        System.out.println("Decrypt:" + decryptedWord);

    }

    public static String encrypt(String word, String key){

        String encryptedWord = "";

        for (char c : word.toCharArray()){
            if(c >= 65 && c <= 90){
                encryptedWord += key.charAt(c - 65);
            }else {
                encryptedWord += c;
            }
        }
        return encryptedWord;
    }

    public static String decrypt(String word, String key){
        String decryptedWord = "";

        word = word.toUpperCase();

        for (char c : word.toCharArray()){
            if(c >= 65 && c <= 90){
                decryptedWord += (char) (key.indexOf(c) + 65);
            }else {
                decryptedWord += c;
            }
        }
        return decryptedWord;
    }

}
