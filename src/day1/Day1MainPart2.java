package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day1MainPart2 {
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
        HashMap<Integer, Integer> timesArray = new HashMap<Integer, Integer>();
        for (int i = 0; i < secondArray.size(); i++) {

            if (timesArray.containsKey(secondArray.get(i))) {
                int key = secondArray.get(i);
                System.out.println(key);
                int value = timesArray.get(secondArray.get(i));
                System.out.println(value);
                int newValue = value + 1;
                System.out.println(newValue);
                timesArray.replace(key, newValue);
            }
            timesArray.putIfAbsent(secondArray.get(i), 1);
        }
        System.out.println(timesArray);
        firstArray.forEach((v) ->{
            System.out.println(v);
            int times = 0;
            if (timesArray.containsKey(v)) {
                times = timesArray.get(v);
            }
            differenceArray.add(v*times);
        });
        System.out.println(differenceArray);
        int sum=0;
        for (int i = 0; i<differenceArray.size();i++){
            sum += differenceArray.get(i);
        }
        System.out.println(sum);
    }
}
