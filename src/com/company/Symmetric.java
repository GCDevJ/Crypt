package com.company;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Symmetric {
    private SecretKey secKey = KeyGenerator.getInstance("AES").generateKey();
    private Cipher c = Cipher.getInstance("AES");

    //Constructor
    public Symmetric() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }


    public String encryptText(String inputString) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        byte [] input = inputString.getBytes("UTF8");
        c.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] encrypted = c.doFinal(input);
        String encryptedText =  java.util.Base64.getEncoder().encodeToString(encrypted);

        return encryptedText;
    }

    public String decriptText(String inputString) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        c.init(Cipher.DECRYPT_MODE, secKey);
        byte[] decrypted = c.doFinal(java.util.Base64.getDecoder().decode(inputString));
        String decryptedText = new String(decrypted);
        return decryptedText;
    }
}
