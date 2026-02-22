import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String word = getWord();

        word = helper.makeUsebleString(word);

        ArrayList<Integer> sub = Kasiski.findRepeatedSequenceDistances(word);

        //System.out.println("Sub Sequences: " + sub);

        int wordLength = Kasiski.keyWordLength(sub);

        //System.out.println("Word Lenght: " + wordLength);

        String keyWord = Kasiski.frequencyAnalysis(word, wordLength);

        //System.out.println("Key word: " + keyWord);

        //String outWord = Vigenere.decrypt(word, keyWord);

        //System.out.println("Out Word: " + outWord);

        //System.out.println("Aufgabe: SHLNWRIHIÜATAAENNHTERKDEDNTLDTELDEWLEORLIRIERRSEEPERTWCR");


        String skytaleEncrypt = Skytale.encrypt("SINDDIEHÜHNERPLATTWIENTELLERWARDERTRAKTORWIEDERSCHNELLER", 8);
        System.out.println("Wort:        : SINDDIEHÜHNERPLATTWIENTELLERWARDERTRAKTORWIEDERSCHNELLER");
        System.out.println("Wort:        : 123456789");
        System.out.println("SkytaleEnrypt: " + skytaleEncrypt);
        System.out.println("Soll         : SHLNWRIHIÜATAAENNHTERKDEDNTLDTELDEWLEORLIRIERRSEEPERTWCR");



        String skytaleDecrypt = Skytale.decrypt("SHLNWRIHIÜATAAENNHTERKDEDNTLDTELDEWLEORLIRIERRSEEPERTWCR", 8);

        //System.out.println("SyktaleDercypt: " + skytaleDecrypt);


    }

    private static String getWord() {
        String s1 = "PWTM!Y!tbADKDgPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUEKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVKVLWZKV";
        String s2 = "hoolahoolagirlslikehooligans";
        String s3 = "Ich hoffe, das ich das ver und dann wieder entschlüsseln kann! Wenn ich nicht das heufig genug verwende geht das wahrscheinlich garnicht oder? Wenn der text nicht lang genug ist, dann funktioniert das nicht richtig! nicht moin nicht moin";

        return s1;
    }
}