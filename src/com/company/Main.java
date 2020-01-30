package com.company;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        File InputFile = new File("./res/in.txt");
        File DecodeFile = new File("./res/out.txt");
        File DecodeAsymFile = new File("./res/outAsym.txt");

        Symmetric symTest = new Symmetric();

        encodeFile(readFile(InputFile), symTest);
        decodeFile(readFile(DecodeFile), symTest);

        Asymmetric asymTest = new Asymmetric();

        encodeFile(readFile(InputFile), asymTest);
        decodeFile(readFile(DecodeAsymFile), asymTest);
    }

    public static List<String> readFile(File file) throws FileNotFoundException {
        List<String> FileText = new ArrayList<String>();
        Scanner FileScanner = new Scanner(file);

        while (FileScanner.hasNext()){FileText.add(FileScanner.nextLine());}
        FileScanner.close();
        return FileText;
    }


    public static void encodeFile(List<String> FileTextList, Symmetric symTest) throws IOException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        out.println("encoding.....");
       PrintWriter writer = null;

        List<String> output = new ArrayList<>();

        for (String s : FileTextList)
            output.add(symTest.encryptText(s));

        try {
            writer = new PrintWriter("res/out.txt");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        assert writer != null;
        for (String string : output){
            writer.println(string);
        }
        writer.close();
        out.println("completely encoded!");
    }

    public static void encodeFile(List<String> FileTextList, Asymmetric symTest) throws IOException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        out.println("encoding.....");
        PrintWriter writer = null;

        List<String> output = new ArrayList<>();

        for (String s : FileTextList)
            output.add(symTest.encrypt(s));

        try {
            writer = new PrintWriter("res/outAsym.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert writer != null;
        for (String string : output) {
            writer.println(string);
        }
        writer.close();
        out.println("completely encoded!");
    }

    public static void decodeFile(List<String> FileTextList, Symmetric symTest) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        out.println("decoding......");
        PrintWriter writer = null;

        List<String> output = new ArrayList<>();

        for (String s : FileTextList)
            output.add(symTest.decriptText(s));

        try {
            writer = new PrintWriter("./res/outDecoded.txt");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        assert writer != null;
        for (String string : output){
            writer.println(string);
        }
        writer.close();
        out.println("completely decoded!");

    }

    public static void decodeFile(List<String> FileTextList, Asymmetric symTest) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        out.println("decoding......");
        PrintWriter writer = null;

        List<String> output = new ArrayList<>();

        for (String s : FileTextList)
            output.add(symTest.decrypt(s));

        try {
            writer = new PrintWriter("./res/outDecodedAsym.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert writer != null;
        for (String string : output) {
            writer.println(string);
        }
        writer.close();
        out.println("completely decoded!");

    }
}
