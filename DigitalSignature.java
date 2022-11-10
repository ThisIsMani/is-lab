import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

public class DigitalSignature {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(1024);
        KeyPair keyPair = kpg.genKeyPair();
        byte[] data = "Sample Text".getBytes("UTF8");
        Signature sig = Signature.getInstance("MD5WithRSA");
        sig.initSign(keyPair.getPrivate());
        sig.update(data);
        byte[] signatureBytes = sig.sign();
        System.out.println("Signature: \n" + Base64.getEncoder().encodeToString(signatureBytes));
        sig.initVerify(keyPair.getPublic());
        sig.update(data);
        System.out.println(sig.verify(signatureBytes));
    }
}