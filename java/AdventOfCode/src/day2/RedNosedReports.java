package day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedNosedReports {
    final static int MAX_SEQUENCE_DIFFERENCE = 3;
    final static int MIN_SEQUENCE_DIFFERENCE = 1;

    public static void main(String[] args) {
        String fileName = "./src/day2/input.txt";

        int validReportsCountBase = getSaveReportsNumber(fileName, false);
        System.out.println("Valid base records count: " + validReportsCountBase);

        int validReportsCountTolerant = getSaveReportsNumber(fileName, true);
        System.out.println("Valid tolerant records count: " + validReportsCountTolerant);
    }

    private static List<Integer> getIntListOutOfStringArray(String[] stringArray) {
        var intArrayList = new ArrayList<Integer>(stringArray.length);

        for (int i = 0; i < stringArray.length; i++) {
            intArrayList.add(i, Integer.parseInt(stringArray[i]));
        }
        return intArrayList;
    }

    private static boolean isValidSequenceBase(List<Integer> sequence) {
        /// init variables for sequence analysis
        boolean isIncreasing = sequence.get(0) < sequence.get(1);

        /// analyze sequence using difference between two following numbers in sequence
        for (int i = 1; i < sequence.size(); i++) {
            int pairDifference;
            if (isIncreasing) {
                pairDifference = sequence.get(i) - sequence.get(i - 1);
            } else {
                pairDifference = sequence.get(i - 1) - sequence.get(i);
            }

            if (pairDifference > MAX_SEQUENCE_DIFFERENCE || pairDifference < MIN_SEQUENCE_DIFFERENCE) {
                return false;
            }
        }
        /// whole sequence is in valid order
        return true;
    }

    private static boolean isValidSequenceTolerant(List<Integer> sequence) {
        /// try without removing level
        if (isValidSequenceBase(sequence)) {
            return true;
        }
        List<Integer> sequence_copy;
        /// inefficiently trying to remove every element and if not valid without it putting it back
        ///  and then try the following one until the whole array is tried. if no iteration is valid
        ///  then the sequence is unsafe regardless of which level is removed
        for (int i = 0; i < sequence.size(); i++) {
            sequence_copy = new ArrayList<>(sequence);
            //noinspection SuspiciousListRemoveInLoop
            sequence_copy.remove(i);
            ///  try base validation without current number if succeeds then safe by removing the current level
            if (isValidSequenceBase(sequence_copy)) {
                return true;
            }
        }

        return false;
    }

    public static int getSaveReportsNumber(String fileName, boolean isTolerant) {
        int saveReportsCount = 0;

        try (var scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNext()) {
                /// parse line into sequence of integers
                String line = scanner.nextLine();
                var stringArr = line.split("\\s+");
                var intSequence = getIntListOutOfStringArray(stringArr);

                /// increment report count if analysis signal valid
                if (isTolerant ? isValidSequenceTolerant(intSequence) : isValidSequenceBase(intSequence)) {
                    saveReportsCount++;
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return saveReportsCount;
    }
}
