package com.dkit.sd2a.johnloane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        App fileIOApp = new App();
        fileIOApp.start();

        /*
        Write a program that does the following:
        Open a file with the name hello.txt
        Store the message "Hello, World!" in the file
        Close the file.
        Open the same file
        Read the message into a string variable and print it
         */
    }

    public void start()
    {
        writeToFile();
        String content = readFromFile("hello.txt");
        System.out.println(content);
    }

    private void writeToFile()
    {
        File file = new File("hello.txt");

        //Use try with resources - this will handle the
        //closure of the file for you
        try(PrintWriter out = new PrintWriter(file))
        {
            out.write("Hello, World!");
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Exception: File not found");
        }
    }

    private String readFromFile(String fileName)
    {
        File file = new File(fileName);
        String content = null;

        try(Scanner input = new Scanner(file))
        {
            content = input.nextLine();
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Exception: Could not find the file to read");
        }
        return content;
    }

}


