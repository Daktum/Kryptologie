import java.util.Dictionary;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {

        String MonoWord = "DIE SCHWALBE HAT UNTER FOLTER ALLES VERRATEN STOP SOFORTIGER ABBRUCH VON OPERATION KLEOPATRA";
        String MonoKey = MonoSubsti.calcKey("Nofretete");


        String vegeWord = "ZIELPERSON HAT HEUTE MORGEN IM MCDONALDS DIE HERRENTOILETTE BENUTZT";
        String vegeKey = "BIGMAC";
        System.out.println(Vigenere.encrypt(vegeWord, vegeKey));
        System.out.println(Vigenere.decrypt("Tvjpme Qollx tqexh iyx Xizjg Tnxh!", "INFO"));
        System.out.println(helper.countChars(vegeWord));
    }


}