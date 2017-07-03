package chapter15.task5;

import java.io.FileNotFoundException;

/**
 * Упражнение 5 из главы 15
 */
public class TestFromFile {

    public static void main(String[] args) {

        FromFile ff = new FromFile();

        String file = "empty";

        try {
            file = ff.readFile(TestFromFile.class.getResourceAsStream("/textFile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(file);
    }
}
