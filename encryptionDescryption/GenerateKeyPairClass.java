package encryptionDescryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GenerateKeyPairClass {
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPair keyPair = getKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("--------------------------------------------");
        System.out.println("Public key: "+Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println("--------------------------------------------");
        System.out.println("Private key: "+Base64.getEncoder().encodeToString(privateKey.getEncoded()));
    }

    public static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    } 
}
