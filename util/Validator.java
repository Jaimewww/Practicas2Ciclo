package util;

public class Validator {
    public static void validateNegatives(double value)throws IllegalArgumentException {
        if(value < 0.0) {
            throw new IllegalArgumentException("The value cannot be less than zero.");
        }
    }

    public static void validateNegatives(int value)throws IllegalArgumentException {
        if(value < 0) {
            throw new IllegalArgumentException("The value cannot be less than zero.");
        }
    }
}
