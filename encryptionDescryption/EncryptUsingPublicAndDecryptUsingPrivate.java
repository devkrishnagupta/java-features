package encryptionDescryption;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class EncryptUsingPublicAndDecryptUsingPrivate {
    
    public static void main(String[] args) throws Exception {
        
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAowuuLIzz9edMGTPTGow/8TeGoGBr66+h0Ne3axWMDxtULP+aes10WUshritK8F7cZrV3ovbBVlvvT8huoNg19AZy8w2LagOg8elx1C7PTwPiwtL8l73543YXCO8uykmLjNIotoiJsVZwkP94LNzrZgXgRQfg/CLtHPF+JUzGTeuoljZhna3yGBihNeyhfDUK1fNqRNlG7i+5N4ZBwscGYKi8fKN7qKrdewQT2WCVkw14/2Wx9TgJ1zrBgK2XjiGs9YBwu0VbzMJvmaqKHJGanK87KB7DC4gSRdxoGhQLJty7j+yIpyXh+kH44+EyNVfzvzC7e/wyo7ar6Ibm6Z4M3QIDAQAB";
        String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCjC64sjPP150wZM9MajD/xN4agYGvrr6HQ17drFYwPG1Qs/5p6zXRZSyGuK0rwXtxmtXei9sFWW+9PyG6g2DX0BnLzDYtqA6Dx6XHULs9PA+LC0vyXvfnjdhcI7y7KSYuM0ii2iImxVnCQ/3gs3OtmBeBFB+D8Iu0c8X4lTMZN66iWNmGdrfIYGKE17KF8NQrV82pE2UbuL7k3hkHCxwZgqLx8o3uoqt17BBPZYJWTDXj/ZbH1OAnXOsGArZeOIaz1gHC7RVvMwm+ZqoockZqcrzsoHsMLiBJF3GgaFAsm3LuP7IinJeH6Qfjj4TI1V/O/MLt7/DKjtqvohubpngzdAgMBAAECggEAHwLMuPqCOEYq6iw6PbVpQAbwmzZbsHMyUteEsmBhyEnJY9ml1y+WrpkkqczgLwHL59kiDSPjt/o6dTFJIVyePnCvkl0EJEDWbsyY8uOIWJ4Dlkys8GuYyNOgI/niK2V7nmgmiDlF/y3SsTF1+Qp312rMsjSCbVJzSOsBtDR7DzyyGU9dzQ1WeGgw46QKXcigszMoNwLM7QjvCZs6lEugeW/jOXK5tgSL8dfQqo3BC7+nRuYdg88gwHDy8hCvTVjnlq+SSGxAAYmJw64JCq8W54vAKFy8m/AD6y0V8uesQtYfyDCKQmRAxQ7OYmKctszBj2dkxLT2+mx1PLiRqT0MXQKBgQDko6oXsN2vfp/FAaucZLcbn4AfYInfXaaVZbOLaxCOa9qQY8iGaS2zP2dbHOuA80LOrMA7EncYUNHLPNGvwtKDMfJDgiuJZIsPoJe9d922gxmYhc9fyA/03VSAlgnhv3qxO8UDEIZU/Bt4/41wWllSrrCL11gHiGdyj44ira54twKBgQC2jo/W6AvEYZi1L7IzsenenzcRbKiJ4tpX/oxeFQs2B5G3f7AIBklkBHQRRAmN7cydqQ9javH5unVMDMj2WsettIoHWh0+K/f4LAK0JdxBc0ymrXbSAirq109h8KZYlqxFTlXtaCgptUWAi5BsSale3mkjtXJKDHjxUZ+QdokLCwKBgEUrqoLeVEMKqOVeGwAGjEsEFyvm9e8okwQxr37nVivwP0Bdn8XiPhwze15aQnlRnw2Nv95fOL6XfNDixoFJDIz6aFO6Jte7HkMND7sXb3EO+ohlOxa8HO+0oiMAwV6VolXKQlEqB6ngV6NklPK/srRL+0djT9N/leRXv+WH6/fDAoGBAKwdJIfdJprz2OGaIkySxIfbXDPVWeEGPA0SNIzPEk7SPBPhErm+E5t0h2lv2AIz3OIX7iYxQgnMPaKBu0ZouDGRMUFVOJTRJ2yXMcVenJYoem/6wzekS4o1jOYt2OdUxv5gqKq3tIX+HZTgAD3YBRMoZcAA5cvijnQWHHY7C2GZAoGAbZPijqaa0imcPMQdYRoX+ja4btXGxA0efVBAkIa6cR/LHEVKaxFmKEP0PLafSI+mYMubBJmWJV3BcVChzLEl5B34qXKPEJrTXaxc6g4t0lzDOM3SBpCM4c4wqmVvrIk+1PCwtOxVT8tUL2ByrxHmG9dK8smbXUORQ+JtasWFL3w=";

        //Original message
        String originalMessage = "Hello, this is a secret message!";

        System.out.println("\nOriginal message: "+originalMessage);

        //Encypt using public key
        String encryptedMessage = encrypt(originalMessage, publicKey);
        System.out.println("\nEncrypted message: "+new String(encryptedMessage));

        //Decrypt using the private key
        String decryptedMessage = decrypt(encryptedMessage, privateKey);
        System.out.println("\nDecrypted Message: "+decryptedMessage);
    }

    public static String encrypt(String message, String publicKeyString) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString.getBytes());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec piubKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey = keyFactory.generatePublic(piubKeySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes(StandardCharsets.UTF_8)));

    }

    public static String decrypt(String encryptedMessage, String privateKeyString) throws Exception {
        byte[] privateBytes = Base64.getDecoder().decode(privateKeyString.getBytes());
        PKCS8EncodedKeySpec privatKeySpec = new PKCS8EncodedKeySpec(privateBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PrivateKey privateKey = keyFactory.generatePrivate(privatKeySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedMessage)));
    }
}
