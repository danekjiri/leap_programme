package roman;

public enum RomanNumeral {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000),
    ;

    private final int decimalValue;

    RomanNumeral(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public static RomanNumeral mapCharToSymbol(char c) throws IllegalArgumentException {
        return switch (c) {
            case 'I', 'i' -> RomanNumeral.I;
            case 'V', 'v' -> RomanNumeral.V;
            case 'X', 'x' -> RomanNumeral.X;
            case 'L', 'l' -> RomanNumeral.L;
            case 'C', 'c' -> RomanNumeral.C;
            case 'D', 'd' -> RomanNumeral.D;
            case 'M', 'm' -> RomanNumeral.M;
            default -> throw new IllegalArgumentException("Unexpected value: " + c);
        };
    }

    public int getDecimalValue() {
        return decimalValue;
    }
}