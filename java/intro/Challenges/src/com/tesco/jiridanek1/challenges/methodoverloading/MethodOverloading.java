package com.tesco.jiridanek1.challenges.methodoverloading;

public class MethodOverloading {
    public static final double INCH_TO_CM = 2.54;
    public static final int FEET_TO_INCHES = 12;

    public static void main(String[] args) {
        System.out.println("11 inch == " + convertToCentimeters(11) + " cm");
        System.out.println("5 feet 8 inch == " + convertToCentimeters(5, 8) + " cm");
    }

    public static double convertToCentimeters(int heightInches) {
        return heightInches * INCH_TO_CM;
    }

    public static double convertToCentimeters(int heightFeet, int heightInches) {
        int feetToInches = heightFeet * FEET_TO_INCHES;
        return convertToCentimeters(feetToInches + heightInches);
    }
}
