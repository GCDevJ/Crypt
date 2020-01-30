package com.company;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        File InputFile = new File("in.txt");
        File OutputFile = new File("out.txt");
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
        decodeFile(readFile(InputFile), symTest);

    }

    public static List<String> readFile(File file) throws FileNotFoundException {
        List<String> FileText = new ArrayList<String>();
        Scanner FileScanner = new Scanner(file);

        while (FileScanner.hasNext()){FileText.add(FileScanner.nextLine());}

        return FileText;
    }

    public static void decodeFile(List<String> FileTextList, Symmetric symTest) throws IOException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        FileWriter writer = new FileWriter("./out.txt");
        for (int i = 0; i < FileTextList.size(); i++) {
            writer.write(symTest.encryptText(FileTextList.get(i)));
        }
    }

}
