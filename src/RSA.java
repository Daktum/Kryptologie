import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    //p-1 + q-1
    private BigInteger p;
    private BigInteger q;

    // phi berechnen

    // öffentlicher Schlüssel
    private BigInteger e;

    // geheimer Schlüssel
    private BigInteger d;
    private BigInteger phi;

    // Modulzahl
    private BigInteger n;

    public RSA() {
        SecureRandom random = new SecureRandom();

        this.p = BigInteger.probablePrime(128, random);
        this.q = BigInteger.probablePrime(128, random);

        this.n = p.multiply(q);

        this.phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));;

        this.e = generatePublicKey();

        this.d = ModMult.modInv(phi, e)[1].mod(phi);

    }

    // e und n des Empfängers
    public BigInteger encrypt(BigInteger message, BigInteger e, BigInteger n) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger cipher) {
        return cipher.modPow(this.d, n);

    }

    public BigInteger getE() {
        return this.e;
    }

    public BigInteger getN() {
        return this.n;
    }

    private BigInteger generatePublicKey() {
        BigInteger e;
        SecureRandom random = new SecureRandom();

        do {
            e = new BigInteger(this.phi.bitLength(), random);

            // make e odd
            e = e.setBit(0);

        } while (e.compareTo(BigInteger.ONE) <= 0
                || e.compareTo(this.phi) >= 0
                || !e.gcd(this.phi).equals(BigInteger.ONE));

        return e;
    }

    @Override
    public String toString() {
        return "RSA{" +
                "\np = " + p +
                "\nq = " + q +
                "\ne = " + e +
                "\nd = " + d +
                "\nphi = " + phi +
                "\nn = " + n +
                "\n}";
    }
}
