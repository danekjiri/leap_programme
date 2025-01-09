package utils;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SmallestBiggestTest {


    @Test
    public void commonCaseInteger() {
        var intArray = new Integer[]{ 1, 4, 2, 0, 42, 6, 7};

        var algorithm = new SmallestBiggest<Integer>();
        algorithm.find(intArray);

        assertEquals(0, algorithm.getSmallest());
        assertEquals(42, algorithm.getBiggest());
    }

    @Test
    public void commonCaseDouble() {
        var doubleArray = new Double[]{ 1.0, 4.2, 2.0, 0.1, 42.42, 3.14, 7.35};

        var algorithm = new SmallestBiggest<Double>();
        algorithm.find(doubleArray);

        assertEquals(0.1, algorithm.getSmallest());
        assertEquals(42.42, algorithm.getBiggest());
    }

    @Test
    public void oneElementInteger() {
        var doubleArray = new Integer[] { 1 };

        var algorithm = new SmallestBiggest<Integer>();
        algorithm.find(doubleArray);

        assertEquals(1 , algorithm.getSmallest());
        assertEquals(1 , algorithm.getBiggest());
    }

    @Test
    public void repeatingElementInteger() {
        var doubleArray = new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1 };

        var algorithm = new SmallestBiggest<Integer>();
        algorithm.find(doubleArray);

        assertEquals(1 , algorithm.getSmallest());
        assertEquals(1 , algorithm.getBiggest());
    }

    @Test
    public void negativeElementsInteger() {
        var doubleArray = new Integer[] { -12, -1, -42, -10 };

        var algorithm = new SmallestBiggest<Integer>();
        algorithm.find(doubleArray);

        assertEquals(-42, algorithm.getSmallest());
        assertEquals(-1 , algorithm.getBiggest());
    }

    @Test
    public void negativeAndPositiveElementsInteger() {
        var doubleArray = new Integer[] { -12, 1, 42, -10 };

        var algorithm = new SmallestBiggest<Integer>();
        algorithm.find(doubleArray);

        assertEquals(-12, algorithm.getSmallest());
        assertEquals(42 , algorithm.getBiggest());
    }

    @Test
    public void EmptyArrayInteger() {
        var emptyArray = new Integer[] { };
        var algorithm = new SmallestBiggest<Integer>();

        assertThrows(IllegalArgumentException.class , () -> algorithm.find(emptyArray));
    }

    @Test
    public void getterBeforeFind() {
        var algorithm = new SmallestBiggest<Integer>();

        assertThrows(SmallestBiggest.PropertiesNotSetException.class , algorithm::getSmallest);
        assertThrows(SmallestBiggest.PropertiesNotSetException.class , algorithm::getBiggest);
    }
}