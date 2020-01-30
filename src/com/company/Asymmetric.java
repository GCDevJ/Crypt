package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Asymmetric {
    KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
    Cipher cipher = Cipher.getInstance("RSA");


    public Asymmetric() throws NoSuchAlgorithmException, NoSuchPaddingException {
    }

    public String encrypt(String inputString) throws InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        byte[] input = inputString.getBytes(StandardCharsets.UTF_8);
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encrypted = cipher.doFinal(input);
        String encryptedText = java.util.Base64.getEncoder().encodeToString(encrypted);

        return encryptedText;
    }

    public String decrypt(String inputString) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decrypted = cipher.doFinal(java.util.Base64.getDecoder().decode(inputString));
        String decryptedText = new String(decrypted);
        return decryptedText;
    }
}
