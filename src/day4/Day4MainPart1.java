package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day4MainPart1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day4/input.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        ArrayList<String> matrix = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            matrix.add(scanner.nextLine());
        }
        // Horizontal
        for (String line : matrix) {
            System.out.println("Horizontal");
            sum += countOccurrences(line, "XMAS");
            sum += countOccurrences(backwardsString(line), "XMAS");
        }
        System.out.println(sum);
        // Vertical
        for (String line : rotate90Degrees(matrix)) {
            System.out.println("Vertical");
            sum += countOccurrences(line, "XMAS");
            sum += countOccurrences(backwardsString(line), "XMAS");
        }
        // 45 degrees right
        System.out.println("rotate45DegreesRight");
        for (String line : rotate45DegreesRight(matrix)) {
            sum += countOccurrences(line, "XMAS");
            sum += countOccurrences(backwardsString(line), "XMAS");
        }
        // 45 Degrees left
        for (String line : rotate45DegreesLeft(matrix)) {
            System.out.println("rotate45DegreesLeft");
            sum += countOccurrences(line, "XMAS");
            sum += countOccurrences(backwardsString(line), "XMAS");
        }
//        ArrayList<String> test = new ArrayList<String>();
//        test.add("abcd");
//        test.add("efgh");
//        test.add("ijkl");
//        test.add("mnop");
//        System.out.println(rotate45DegreesRight(test));

        scanner.close();
        System.out.println("sum " + sum);
    }

    public static int countOccurrences(String text, String word) {
        System.out.println(text);
        int count = 0, index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += 1; //word.length();
        }
        System.out.println(count);
        return count;
    }

    private static String backwardsString(String originalString) {
        // StringBuilder är mer effektiv för att manipulera strängar än String
        StringBuilder reversedStringBuilder = new StringBuilder(originalString);
        // reverse() metoden vänder på ordningen direkt i StringBuilder objektet
        reversedStringBuilder.reverse();
        // Konvertera tillbaka till en String och returnera
        return reversedStringBuilder.toString();
    }

    public static ArrayList<String> rotate90Degrees(ArrayList<String> input) {
        int rows = input.size();
        int cols = input.get(0).length(); // Antag att alla strängar har samma längd
        ArrayList<String> rotated = new ArrayList<>();
        for (int j = 0; j < cols; j++) {
            StringBuilder newRow = new StringBuilder();
            for (int i = rows - 1; i >= 0; i--) {
                newRow.append(input.get(i).charAt(j));
            }
            rotated.add(newRow.toString());
        }
        return rotated;
    }

    public static ArrayList<String> rotate45DegreesRight(ArrayList<String> input) {
        int rows = input.size();
        int cols = input.get(0).length();
        ArrayList<String> rotatedList = new ArrayList<>();

        // fram till diagonalen
        for (int row = 0; row < rows; row++) {
            String newString = "";
            int rowTemp = row;
            for (int col = 0; col <= row; col++) {
                newString = newString + input.get(rowTemp).charAt(col);
                rowTemp--;
            }
            rotatedList.add(newString);
        }
        // efter diagonalen
        for (int col = 1; col < cols; col++) {
            String newString = "";
            int rowTemp = rows - 1;
            int colTemp = col;
            while (colTemp < cols) {
                newString = newString + input.get(rowTemp).charAt(colTemp);
                rowTemp--;
                colTemp++;
            }
            rotatedList.add(newString);
        }
        // System.out.println(rotatedList);
        return rotatedList;
    }

    public static ArrayList<String> rotate45DegreesLeft(ArrayList<String> input) {
        int rows = input.size();
        int cols = input.get(0).length();
        ArrayList<String> rotatedList = new ArrayList<>();

        // fram till diagonalen
        for (int row = 0; row < rows; row++) {
            String newString = "";
            int rowTemp = row;
            int colTemp = cols-1;
            while(rowTemp>=0){
                newString = newString + input.get(rowTemp).charAt(colTemp);
                colTemp--;
                rowTemp--;
            }
            rotatedList.add(newString);
        }
        // efter diagonalen
        for (int row = 1; row < rows; row++) {
            String newString = "";
            int rowTemp = row;
            int colTemp = 0;
            while (rowTemp < rows) {
                newString = newString + input.get(rowTemp).charAt(colTemp);
                rowTemp++;
                colTemp++;
            }
            rotatedList.add(newString);
        }
        return rotatedList;
    }
}
