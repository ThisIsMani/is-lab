import java.security.*;

public class DSAKeyGen {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(1024);
        KeyPair keypair = keyPairGenerator.genKeyPair();
        PrivateKey privateKey = keypair.getPrivate();
        System.out.println(privateKey);
        PublicKey publicKey = keypair.getPublic();
        System.out.println(publicKey);
    }
}