package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day2MainPart2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day2/demo.txt");
        Scanner scanner = new Scanner(file);
        int rows = 0;
        while (scanner.hasNextLine()) {
            String lineString = scanner.nextLine();
            String[] lineArray = lineString.split("\\s+");
            System.out.println(Arrays.toString(lineArray));
            // Increasing
            int max = Integer.parseInt(lineArray[0]);
            int numbers = 1;
            boolean error = false;
            for (int i = 1; i < lineArray.length; i++) {
                int numberInt = Integer.parseInt(lineArray[i]);
                // if (numberInt - max > 3) break;
                if (numberInt <= max || numberInt - max > 3) {
                    if (error) break;
                    error = true;
                    System.out.println("higher remove " + i);
                } else {
                    max = numberInt;
                    System.out.println("new max is " + max);
                }
                numbers++;
            }
            if (max == Integer.parseInt(lineArray[lineArray.length - 1]) && numbers == lineArray.length) {
                rows++;
                System.out.println("******************************* hit higher");
            } else {

                // degreesing
                numbers = 1;
                error = false;
                int min = Integer.parseInt(lineArray[lineArray.length - 1]);
                for (int i = lineArray.length - 2; i >= 0; i--) {
                    int numberInt = Integer.parseInt(lineArray[i]);
                    // if (numberInt - min > 3) break;
                    if (numberInt <= min || numberInt - min > 3 ) {
                        if (error) break;
                        error = true;
                        System.out.println("lower remove " + i);
                    } else {
                        min = numberInt;
                        System.out.println("new min is " + min);
                    }
                    numbers++;
                }
                if (min == Integer.parseInt(lineArray[0]) && numbers == lineArray.length) {
                    rows++;
                    System.out.println(" ************************ hit lower");
                } else {
                    System.out.println(" try to remove first post, test higher");
                    max = Integer.parseInt(lineArray[1]);
                    numbers = 2;
                    for (int i = 2; i < lineArray.length; i++) {
                        int numberInt = Integer.parseInt(lineArray[i]);
                        if (numberInt <= max) break;
                        if (numberInt - max > 3) break;
                        max = numberInt;
                        numbers++;
                    }
                    if (max == Integer.parseInt(lineArray[lineArray.length - 1]) && numbers == lineArray.length) {
                        rows++;
                        System.out.println("######################### hit higher");
                    } else {
                        System.out.println("test lower");
                        // degreesing
                        numbers = 2;
                        min = Integer.parseInt(lineArray[lineArray.length - 1]);
                        for (int i = lineArray.length - 2; i >= 1; i--) {
                            int numberInt = Integer.parseInt(lineArray[i]);
                            if (numberInt <= min) break;
                            if (numberInt - min > 3) break;
                            min = numberInt;
                            numbers++;
                        }
                        if (min == Integer.parseInt(lineArray[1]) && numbers == lineArray.length) {
                            rows++;
                            System.out.println("############################# hit lower");
                        } else {
                            System.out.println(" try to remove last post, test higher");
                            max = Integer.parseInt(lineArray[0]);
                            numbers = 2;
                            for (int i = 1; i < lineArray.length-1; i++) {
                                int numberInt = Integer.parseInt(lineArray[i]);
                                if (numberInt <= max) break;
                                if (numberInt - max > 3) break;
                                max = numberInt;
                                numbers++;
                            }
                            if (max == Integer.parseInt(lineArray[lineArray.length - 2]) && numbers == lineArray.length) {
                                rows++;
                                System.out.println("######################### hit higher");
                            } else {
                                System.out.println("test lower");
                                // degreesing
                                numbers = 2;
                                min = Integer.parseInt(lineArray[lineArray.length - 2]);
                                for (int i = lineArray.length - 3; i >= 0; i--) {
                                    int numberInt = Integer.parseInt(lineArray[i]);
                                    if (numberInt <= min) break;
                                    if (numberInt - min > 3) break;
                                    min = numberInt;
                                    numbers++;
                                }
                                if (min == Integer.parseInt(lineArray[0]) && numbers == lineArray.length) {
                                    rows++;
                                    System.out.println("############################# hit lower");
                                }
                            }
                        }
                    }
                }

            }
        }
        scanner.close();
        System.out.println(rows);
    }
}


// 426 too low
// 439 too low
// 443 too low