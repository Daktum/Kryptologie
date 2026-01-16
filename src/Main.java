public class Main {
    public static void main(String[] args) {

        String word = "DIE SCHWALBE HAT UNTER FOLTER ALLES VERRATEN STOP SOFORTIGER ABBRUCH VON OPERATION KLEOPATRA";
        String key = MonoSubsti.calcKey("Nofretete");

        System.out.println(key);


        String encryptedWord = MonoSubsti.encrypt(word, MonoSubsti.calcKey(key));
        System.out.println(encryptedWord);

    }
}