package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


public class DayXPart1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day6/demo.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        HashMap<Integer,Integer> rules = new HashMap<>();
        while (!Objects.equals(scanner.nextLine(), "")) {
            String line = scanner.nextLine();
            String[] lineArr = line.split("\\|");
            rules.put(Integer.parseInt(lineArr[0]),Integer.parseInt(lineArr[1]));
        }
        System.out.println(rules);
        System.out.println("sum " + sum);
    }

}
