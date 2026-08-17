import java.math.BigInteger;

public class ModMult_Vorlage {

    /*
     *  Schlüsselbedingung: ggT(d, n) = 1
     *  Modulare Inverse: d * e = 1 (mod n)
     */

    // öffentlicher Schlüssel
    private static BigInteger e = new BigInteger("49");
    // geheimer Schlüssel
    private static BigInteger d = new BigInteger("775517959261225265313877628572204089387832653836742449");
    // Modulzahl
    private static BigInteger n = new BigInteger("1000010000100001000010000100001000010000100001000010000");

    // ###################################################################################

    public static BigInteger ggt(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        }

        return ggt(b, a.remainder(b));    // a_neu = b_alt, b_neu = a_alt % b_alt
    }

    public static BigInteger[] modInv(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[]{BigInteger.ONE, BigInteger.ZERO};
        }

        BigInteger[] xy = modInv(b, a.remainder(b));           // a_neu = b_alt
        // b_neu = a_alt % b_alt

        BigInteger x = xy[1];                      // x_neu = y_alt
        BigInteger y = xy[0].subtract(a.divide(b).multiply(xy[1]));    // y_neu = x_alt - (a / b) * y_alt

        return new BigInteger[]{x, y};
    }

    public static void main(String[] argv) {
        BigInteger a = new BigInteger("120");
        BigInteger b = new BigInteger("23");

        System.out.println("ggT(d,N) = " + ggt(n, d));
        System.out.println("e = " + modInv(n, d)[1]);

        System.out.println(stringToBigInt("AMOIN_BEN"));
    }

    public static BigInteger stringToBigInt(String text) {
        StringBuilder zahl = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            // ... selber machen ...
            char c = text.charAt(i);

            if (c == '_') {
                zahl.append("00");
            } else {
                int zeichen = c - 64;
                zahl.append(zeichen < 10 ? "0" + zeichen : zeichen);
            }

        }
        return new BigInteger(zahl.toString());
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