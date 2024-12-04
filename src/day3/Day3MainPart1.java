package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3MainPart1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day3/input.txt");
        Scanner scanner = new Scanner(file);
        int sum=0;
        while (scanner.hasNextLine()) {
            String lineString = scanner.nextLine();
            System.out.println(lineString.length());
            String[] muls = lineString.split("mul");
            System.out.println(Arrays.toString(muls));
            Pattern pattern = Pattern.compile("^\\((\\d{1,3}),(\\d{1,3})\\)\\?*");
            for (String mul: muls){
                System.out.println(mul);
                Matcher matcher = pattern.matcher(mul);
                if (matcher.find()) {
                    String group1 = matcher.group(1); // Första siffran
                    String group2 = matcher.group(2); // Andra siffran
                    System.out.println(group1+ " * "+group2);
                    sum += Integer.parseInt(group1) * Integer.parseInt(group2);
                } else {
                    System.out.println("Ingen matchning hittades.");
                }

            }

        }
        scanner.close();
        System.out.println("sum "+sum);
    }
}

// 181733301 too High