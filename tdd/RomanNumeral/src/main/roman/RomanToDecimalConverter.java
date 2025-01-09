package roman;

public class RomanToDecimalConverter {

    /**
     * Converts Roman Numeral String into decimal integer
     * @param roman Roman Numeral as String that will be converted
     * @return int representation of Roman Numeral given
     * @throws IllegalArgumentException null, empty String or invalid symbol in 'roman' passed
     */
    public static int romanToDecimal(String roman) throws IllegalArgumentException {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Given argument is null or empty.");
        }

        int result = 0;
        /// init prev symbol for further computation
        char currentChar = roman.charAt(0);
        RomanNumeral prevRoman = RomanNumeral.mapCharToSymbol(currentChar);


        ///  continue from second symbol until end of roman numeral
        for (int i = 1; i < roman.length(); i++) {
            currentChar = roman.charAt(i);
            RomanNumeral currentRoman = RomanNumeral.mapCharToSymbol(currentChar);

            /// add or subtract previous according to the comparator
            if (prevRoman.getDecimalValue() < currentRoman.getDecimalValue()) {
                result -= prevRoman.getDecimalValue();
            } else {
                result += prevRoman.getDecimalValue();
            }

            prevRoman = currentRoman;
        }

        /// last digit was not added so far
        result += prevRoman.getDecimalValue();
        return result;
    }
}