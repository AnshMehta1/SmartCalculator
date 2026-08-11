package com.ansh.calculator;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        // StringBuilder is preferred inside loops because it reuses the same
        // mutable object instead of creating a new String for every concatenation.
        for (int i = 0; i < 10; i++) {
            result.append(i).append(" ");
        }

        System.out.println("StringBuilder completed successfully.");
        System.out.println("Length: " + result.length());
    }
}