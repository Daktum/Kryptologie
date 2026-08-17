import java.math.BigInteger;

public class ModMult_Vorlage {

    /*
     *  Schlüsselbedingung: ggT(d, n) = 1
     *  Modulare Inverse: d * e = 1 (mod n)
     */

    public static int ea(int a, int b) {
        if (b == 0) {
            return a;
        }

        return ea(b, a % b);    // a_neu = b_alt, b_neu = a_alt % b_alt
    }

    public static int[] eea(int a, int b) {
        if (b == 0) {
            return new int[] { 1, 0 };
        }

        int[] xy = eea(b, a % b);           // a_neu = b_alt
        // b_neu = a_alt % b_alt

        int x = xy[1];                      // x_neu = y_alt
        int y = xy[0] - (a / b) * xy[1];    // y_neu = x_alt - (a / b) * y_alt

        return new int[]{x, y};
    }

    public static void main(String[] argv) {
        System.out.println("ggT(d,N) = " + ea(120, 23));
        System.out.println("e = " + eea(120, 23)[1]);
    }

    // ###################################################################################

    // öffentlicher Schlüssel
    private static BigInteger e = new BigInteger("49");
    // geheimer Schlüssel
    private static BigInteger d = new BigInteger("775517959261225265313877628572204089387832653836742449");
    // Modulzahl
    private static BigInteger n = new BigInteger("1000010000100001000010000100001000010000100001000010000");

    public static BigInteger stringToBigInt(String text) {
        String zahl = "";

        for (int i = 0; i < text.length(); i++) {
            // ... selber machen ...
        }

        return new BigInteger(zahl);
    }

    public static String bigIntToString(BigInteger zahl) {
        String ziffern = zahl.toString();

        // verlorene führende 0 ergänzen
        if (ziffern.length() % 2 != 0) {
            ziffern = "0" + ziffern;
        }

        String text = "";

        for (int i = 0; i < ziffern.length(); i += 2) {
            int wert = Integer.parseInt(ziffern.substring(i, i + 2));

            if (wert == 0) {
                text += "_";
            } else {
                text += (char) ('A' + wert - 1);
            }
        }

        return text;
    }
}