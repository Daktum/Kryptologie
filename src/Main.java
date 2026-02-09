public class Main {
    public static void main(String[] args) {
        String vegeWord = "Zielperson Hat Heute MORGEN IM MCDONALDS DIE HERRENTOILETTE BENUTZT";
        String vegeKey = "BIGMAC";
        System.out.println(Vigenere.encrypt(vegeWord, vegeKey));
        System.out.println(Vigenere.decrypt("Tvjpme Qollx tqexh iyx Xizjg Tnxh!", "INFO"));
        System.out.println("test");
    }
}