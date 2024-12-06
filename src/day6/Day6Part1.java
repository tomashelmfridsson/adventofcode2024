package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;


public class Day6Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tomashelmfridsson/IdeaProjects/adventofcode2024/src/day6/input.txt");
        Scanner scanner = new Scanner(file);
        int sum = 0;
        List<int[]> pathArr = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        List<String[]> matrix = new ArrayList<>();
        String direction = "up";
        int[] position = new int[2];
        int startRow = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            lines.add(line);
            if (line.contains("^")) {
//                System.out.println("startrow found at row " + startRow);
//                System.out.println(line);
                // startrow
                position[0] = startRow;
                position[1] = line.indexOf('^');
                System.out.println(Arrays.toString(position));
            }
            startRow++;
            String[] lineArr = line.split("");
            matrix.add(lineArr);
        }
//        System.out.println(lines);
//        System.out.println(Arrays.toString(matrix.get(0)));
//        System.out.println(matrix.get(0)[4]);
//        System.out.println(moveOk(position, matrix));
//        System.out.println(moveOk(new int[]{0, 4}, matrix));
//        System.out.println(stillInside(new int[]{10, 0}, matrix));
        while (stillInside(position, matrix)) {
//            System.out.println(Arrays.toString(position));
//            System.out.println(direction);
            while (stillInside(position, matrix) && moveOk(position, matrix)) {
                boolean found = false;
//                System.out.println("inside with position "+ Arrays.toString(position));
//                System.out.println(pathArr);
                for (int[] coordinates : pathArr) {
//                    System.out.println(Arrays.toString(coordinates));
                    if (coordinates[0] == position[0] && coordinates[1] == position[1]) {
//                        System.out.println("exists");
                        found = true;
                        break;
                    }
                }
                if (!found) {
//                    System.out.println("Add to path " + Arrays.toString(position));
                    int row= position[0];
                    int col = position[1];
                    pathArr.add(new int[]{row,col});
                }
                if (direction.equals("up")) position[0]--;
                if (direction.equals("down")) position[0]++;
                if (direction.equals("right")) position[1]++;
                if (direction.equals("left")) position[1]--;
//                System.out.println(Arrays.toString(position));
            }
            if (stillInside(position, matrix)) {
//                System.out.println("Still insida");
                switch (direction) {
                    case "up": {
                        direction = "right";
                        position[0]++;
                        position[1]++;
                        break;
                    }
                    case "down": {
                        direction = "left";
                        position[0]--;
                        position[1]--;
                        break;
                    }
                    case "right": {
                        direction = "down";
                        position[1]--;
                        position[0]++;
                        break;
                    }
                    case "left": {
                        direction = "up";
                        position[1]++;
                        position[0]--;
                        break;
                    }
                }
            }

        }
//        System.out.println(pathArr);
        System.out.println(pathArr.size());
    }

    public static boolean moveOk(int[] coord, List<String[]> matrix) {
        return !Objects.equals(matrix.get(coord[0])[coord[1]], "#");
    }

    public static boolean stillInside(int[] coord, List<String[]> matrix) {
        int col = coord[1];
        int row = coord[0];
        if (row < 0 || row >= matrix.size()) return false;
        if (col < 0 || col >= matrix.get(0).length) return false;
        return true;
    }

}
