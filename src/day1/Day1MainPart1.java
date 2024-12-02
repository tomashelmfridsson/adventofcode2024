package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1MainPart1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day1/input.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> firstArray = new ArrayList<Integer>();
        ArrayList<Integer> secondArray = new ArrayList<Integer>();
        ArrayList<Integer> differenceArray = new ArrayList<Integer>();
        while (scanner.hasNextLine()) {
            int i = scanner.nextInt();
            firstArray.add(i);
            int j = scanner.nextInt();
            secondArray.add(j);
        }
        scanner.close();
        Collections.sort(firstArray);
        Collections.sort(secondArray);
        System.out.println(firstArray);
        System.out.println(secondArray);
        if (firstArray.size() != secondArray.size()) System.out.println("different sizes");
        else{
            for (int i = 0; i<firstArray.size();i++){
                differenceArray.add(Math.abs(firstArray.get(i) - secondArray.get(i)));
            }
        }
        System.out.println(differenceArray);
        int sum=0;
        for (int i = 0; i<differenceArray.size();i++){
            sum += differenceArray.get(i);
        }
        System.out.println(sum);
    }
}
