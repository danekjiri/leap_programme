package utils;

public class SmallestBiggest<Tnumber extends Number & Comparable<Tnumber>> {
    private Tnumber smallest, biggest;
    private boolean findFinished = false;

    public Tnumber getSmallest() throws PropertiesNotSetException {
        if (!findFinished) {
            throw new PropertiesNotSetException("The 'Smallest' number has not been set");
        }
        return smallest;
    }

    public Tnumber getBiggest() throws PropertiesNotSetException {
        if (!findFinished) {
            throw new PropertiesNotSetException("The 'Biggest' number has not been set");
        }
        return biggest;
    }

    /**
     * Exception class that is thrown if invalid getters are called
     */
    public static class PropertiesNotSetException extends RuntimeException {
        public PropertiesNotSetException(String message) {
            super(message);
        }

    }

    /**
     * Find the smallest and the biggest number in given array, values are then accessible
     *  using getBiggest() and getSmallest() getters
     * @param array where given values are searched
     * @throws IllegalArgumentException if empty array is passed
     */
    public void find(Tnumber[] array) throws IllegalArgumentException {
        findFinished = false;
        if (array.length < 1) {
            throw new IllegalArgumentException("Array is empty");
        }

        biggest = smallest = array[0];
        for (Tnumber num : array) {
            if (num.compareTo(biggest) > 0) {
                biggest = num;
            }

            if (num.compareTo(smallest) < 0) {
                smallest = num;
            }
        }

        findFinished = true;
    }
}
