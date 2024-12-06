package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day5/input.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        List<String> rules = new ArrayList<>();
        List<String> data = new ArrayList<>();
        List<String> ok = new ArrayList<>();
        boolean part1 = true;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!part1) {
                data.add(line);   // rows to validate
            }
            if (Objects.equals(line, "")) part1 = false;
            if (part1) {
                rules.add(line); // rules
            }

        }
        System.out.println(rules);
        System.out.println(data);
        boolean verified;
        for (String row : data) {
            verified = true;
            // System.out.println(row);
            String[] rowArr = row.split(",");
            //System.out.println(Arrays.toString(rowArr));
            for (String number : rowArr) {
//                    System.out.println(number);
                if (verified) {
                    for (String rule : rules) {
//                            System.out.println(rule);
                        Pattern pattern = Pattern.compile(number + "\\|(.*)");
                        Matcher matcher = pattern.matcher(rule);
                        if (matcher.find()) {
                            String ruleNumber = matcher.group(1);
//                                System.out.println(ruleNumber);
//                                System.out.println(row.indexOf(number));
//                                System.out.println(row.indexOf(ruleNumber));
                            if (row.indexOf(number) > row.indexOf(ruleNumber) && row.contains(ruleNumber)) {
                                verified = false;
                                System.out.println("*********Fail***********");
                                System.out.println(row);
                                System.out.println(number);
                                System.out.println(rule);
                                System.out.println("************************");
                            }
                        }
                    }
                }
                
            }
            if (verified) ok.add(row);
        }
        System.out.println(ok);

        for (String okRow : ok) {
            System.out.println(okRow);
            String[] okArr = okRow.split(",");
            System.out.println(Arrays.toString(okArr));
            System.out.println(okArr.length);
            int middlePost = (okArr.length) / 2;
            System.out.println(okArr[middlePost]);
            sum += Integer.parseInt(okArr[middlePost]);
        }

        System.out.println("sum " + sum);
    }

}
