package roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToDecimalConverterTest {

    @Test
    public void basicNumerals() {
        assertEquals(1, RomanToDecimalConverter.romanToDecimal("I"));
        assertEquals(5, RomanToDecimalConverter.romanToDecimal("V"));
        assertEquals(10, RomanToDecimalConverter.romanToDecimal("X"));
        assertEquals(50, RomanToDecimalConverter.romanToDecimal("L"));
        assertEquals(100, RomanToDecimalConverter.romanToDecimal("C"));
        assertEquals(500, RomanToDecimalConverter.romanToDecimal("D"));
        assertEquals(1000, RomanToDecimalConverter.romanToDecimal("M"));
    }

    @Test
    public void composedAdditionNumerals() {
        assertEquals(3, RomanToDecimalConverter.romanToDecimal("III"));
        assertEquals(7, RomanToDecimalConverter.romanToDecimal("VII"));
        assertEquals(30, RomanToDecimalConverter.romanToDecimal("XXX"));
        assertEquals(70, RomanToDecimalConverter.romanToDecimal("LXX"));
        assertEquals(300, RomanToDecimalConverter.romanToDecimal("CCC"));
        assertEquals(700, RomanToDecimalConverter.romanToDecimal("DCC"));
        assertEquals(3000, RomanToDecimalConverter.romanToDecimal("MMM"));
    }

    @Test
    public void composedSubtractionNumerals() {
        assertEquals(4, RomanToDecimalConverter.romanToDecimal("IV"));
        assertEquals(9, RomanToDecimalConverter.romanToDecimal("IX"));
        assertEquals(49, RomanToDecimalConverter.romanToDecimal("XLIX"));
        assertEquals(99, RomanToDecimalConverter.romanToDecimal("XCIX"));
        assertEquals(499, RomanToDecimalConverter.romanToDecimal("CDXCIX"));
        assertEquals(999, RomanToDecimalConverter.romanToDecimal("CMXCIX"));
    }
}