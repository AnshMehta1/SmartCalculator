package com.ansh.calculator;

public class PrimitiveTypes {
    public static void main(String[] args) {

        // Block 1: integer division
        int a = 17, b = 5;
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println((double) a / b);

        // Block 2: Integer cache
        Integer x = 127;
        Integer y = 127;
        Integer p = 200;
        Integer q = 200;

        System.out.println(x == y);
        System.out.println(p == q);
        System.out.println(p.equals(q));

        // Integer values from -128 to 127 are cached and reused, while 200 is outside
        // the default Integer cache range, so p and q refer to different objects.
    }
}