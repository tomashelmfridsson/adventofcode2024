package day3;

import javax.naming.PartialResultException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3MainPart2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day3/input.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        ArrayList<String> enabledArray = new ArrayList<String>();
        String lineString = "";
        while (scanner.hasNextLine()) {
            lineString = lineString + scanner.nextLine();
        }
        System.out.println(lineString);
        Pattern dontPattern = Pattern.compile("don't\\(\\)");
        Pattern doPattern = Pattern.compile("do\\(\\)");

        boolean go = true;
        do {
            String[] arrayDontDo = lineString.split(String.valueOf(dontPattern), 2);
            System.out.println(Arrays.toString(arrayDontDo));
            enabledArray.add(arrayDontDo[0]);
            lineString = removeDontDo(arrayDontDo[1]);
            // System.out.println(lineString);
            // check if more don't() exists
            Matcher matcher = dontPattern.matcher(lineString);
            if (matcher.find()) {
                // System.out.println("continue");
            } else {
                go = false;
                enabledArray.add(lineString);
            }
        } while (go);

        System.out.println("**************** enabledarray");
        System.out.println(enabledArray);


        for (String lines : enabledArray) {
            String[] muls = lines.split("mul");
            System.out.println(Arrays.toString(muls));
            Pattern pattern = Pattern.compile("^\\((\\d{1,3}),(\\d{1,3})\\)");
            for (String mul : muls) {
                System.out.println(mul);
                Matcher matcher = pattern.matcher(mul);
                if (matcher.find()) {
                    String group1 = matcher.group(1); // Första siffran
                    String group2 = matcher.group(2); // Andra siffran
                    System.out.println(group1 + " * " + group2);
                    sum += Integer.parseInt(group1) * Integer.parseInt(group2);
                } else {
                    System.out.println("Ingen matchning hittades.");
                }

            }


        }
        scanner.close();
        System.out.println("sum " + sum);
    }

    public static String removeDontDo(String lineString) {
        Pattern doPattern = Pattern.compile("do\\(\\)");
        // System.out.println("input lineString " + lineString);
        Matcher matcher = doPattern.matcher(lineString);
        if (matcher.find()) {
            String[] arrayDo = lineString.split(String.valueOf(doPattern), 2);
            return arrayDo[1];
        } else return "";
    }
}

// 102559010 too High
// 89912299 too High
// 87163705 OK