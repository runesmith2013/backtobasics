package com.rob.java.b2b;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TWRTest {

    @Test
    public void testBasicTryWithResources() {
        try (Scanner scanner = new Scanner(new File("text.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMultipleResources() throws FileNotFoundException {

        try(Scanner scanner = new Scanner(new File("test.txt"));
          PrintWriter pw = new PrintWriter(new File("test.txt"))) {
            while (scanner.hasNext()) {
                pw.print(scanner.nextLine());
            }
        }
    }


}
