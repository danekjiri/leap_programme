package day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class HistorianHysteria {
    public static void main(String[] args) {
        String fileName = "./src/day1/input.txt";

        int distance = findDistanceComparingLowest(fileName);
        System.out.println("Distance: " + distance);

        int score = findSimilarityScore(fileName);
        System.out.println("Score: " + score);
    }

    public static int findSimilarityScore(String fileName) {
        /// init data structures
        ArrayList<Integer> leftList = new ArrayList<>();
        Hashtable<Integer, Integer> occurrencesTable = new Hashtable<>();

        /// load data from file into ArrayList<Integer> and Hashtable<Integer, Integer> occurrences
        try (var scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNext()) {
                leftList.add(scanner.nextInt());

                int rightNumber = scanner.nextInt();
                if (occurrencesTable.containsKey(rightNumber)) {
                    occurrencesTable.put(rightNumber, occurrencesTable.get(rightNumber) + 1);
                } else {
                    occurrencesTable.put(rightNumber, 1);
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        ///  compute similarity score using occurrence table
        int similarityScore = 0;
        for (Integer leftNumber : leftList) {
            Integer intOccurrences = occurrencesTable.get(leftNumber);
            similarityScore += leftNumber * (intOccurrences == null ? 0 : intOccurrences);
        }
        return similarityScore;
    }

    public static int findDistanceComparingLowest(String fileName) {
        ///  init data structures
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        /// load data from file into ArrayList<Integer>s
        try (var scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNext()) {
                leftList.add(scanner.nextInt());
                rightList.add(scanner.nextInt());
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        ///  check if arrays size equal
        assert leftList.size() == rightList.size();

        /// sort both arrays for comparison
        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);

        /// compute distance for similar lowest number in sequence
        int distanceCounter = 0;
        for (int i = 0; i < leftList.size(); i++) {
            distanceCounter += Math.abs(leftList.get(i) - rightList.get(i));
        }
        return distanceCounter;
    }
}