package temp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day5Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day4/input.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        ArrayList<String> matrix = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            matrix.add(scanner.nextLine());
        }
        System.out.println("sum " + sum);
    }

}
