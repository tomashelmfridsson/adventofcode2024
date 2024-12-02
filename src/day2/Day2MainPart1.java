package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day2MainPart1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day2/input.txt");
        Scanner scanner = new Scanner(file);
        int rows = 0;
        while (scanner.hasNextLine()) {
            String lineString = scanner.nextLine();
            String[] lineArray = lineString.split("\\s+");
            System.out.println(Arrays.toString(lineArray));
            // Increasing
            int max = Integer.parseInt(lineArray[0]);
            int numbers = 1;
            for (int i = 1 ; i< lineArray.length;i++) {
                int numberInt = Integer.parseInt(lineArray[i]);
                if (numberInt <= max) break;
                if (numberInt - max > 3) break;
                max = numberInt;
                numbers++;
            }
            if (max == Integer.parseInt(lineArray[lineArray.length - 1]) && numbers == lineArray.length) {
                rows++;
                System.out.println("hit higher");
            }
            // degreesing
            numbers = 1;
            int min = Integer.parseInt(lineArray[lineArray.length - 1]);
            for (int i = lineArray.length-2; i >= 0; i--) {
                int numberInt = Integer.parseInt(lineArray[i]);
                if (numberInt <= min) break;
                if (numberInt-min > 3) break;
                min = numberInt;
                numbers++;
            }
            if (min == Integer.parseInt(lineArray[0]) && numbers == lineArray.length) {
                rows++;
                System.out.println("hit lower");
            }


        }
        scanner.close();
        System.out.println(rows);
    }
}

// 469 too high
// 407 OK