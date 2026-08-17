package com.savoira.assessment;

public class TypeDemo {

    public static void main(String[] args) {

        // Block 1
        int a = 9, b = 2;

        // Prediction:
        // 4
        // 1
        // 4.5

        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println((double) a / b);

        System.out.println();

        // Block 2
        Integer x = 100;
        Integer y = 100;
        Integer p = 200;
        Integer q = 200;

        // Prediction:
        // true
        // false
        // true

        System.out.println(x == y);
        System.out.println(p == q);
        System.out.println(p.equals(q));

        /*
         * WHY:
         * Integer objects in Java are cached for values from -128 to 127
         * by default. Therefore, x and y both refer to the same cached
         * Integer object for 100, so x == y is true.
         *
         * 200 is outside the guaranteed Integer cache range, so p and q
         * are normally different Integer objects. Therefore p == q is false.
         *
         * equals() compares the actual integer values rather than object
         * references, so p.equals(q) is true.
         */
    }
}