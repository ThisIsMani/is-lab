import java.math.BigInteger;
import java.security.*;

import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class DiffieHellman {
    
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DiffieHellman");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
        DHPublicKeySpec dHPublicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), DHPublicKeySpec.class);
        System.out.println("Public Key is: " + dHPublicKeySpec);
        SecureRandom secureRandom = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(512, secureRandom);
        BigInteger q = BigInteger.probablePrime(512, secureRandom);
        DHParameterSpec dhParameterSpec = new DHParameterSpec(p, q);
        keyPairGenerator.initialize(dhParameterSpec);
        keyPair = keyPairGenerator.genKeyPair();
        dHPublicKeySpec = keyFactory.getKeySpec(keyPair.getPublic(), DHPublicKeySpec.class);
        System.out.println("Public Key is: " + dHPublicKeySpec);
    }
}