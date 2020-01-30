package com.company;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {


    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
       // File file = new File("./file.txt");
      //  Scanner FileScanner = new Scanner(file);

        String inputString = "test";
        Symmetric symTest = new Symmetric();
        System.out.println("\nSymmetric \n\nEncode:");
        //Encode
        String text = symTest.encryptText(inputString);
        System.out.println(text);
        //Decode
        System.out.println("\nDecode:");
        text = symTest.decriptText(text);
        System.out.println(text);


    }
}
