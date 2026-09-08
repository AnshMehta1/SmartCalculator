package com.ansh.w7;

public class BugFixer {
    static double findLargest(double[] amounts) {
        // Bug 1 fix: max = 0 fails when every value is negative and so we use the first element.
        double max = amounts[0];
        // Bug 2 fix: valid indexes end at length - 1, so <= causes ArrayIndexOutOfBoundsException.
        for (int i = 1; i < amounts.length; i++) {
            if (amounts[i] > max) max = amounts[i];
        }
        return max;
    }
}
