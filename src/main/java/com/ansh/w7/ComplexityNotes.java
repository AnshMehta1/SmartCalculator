package com.ansh.w7;

public class ComplexityNotes {
    /*
     * Finding one account by ID:
     * Linear scan = O(n); HashMap lookup = O(1) average-case.
     * For 1 million accounts, choose HashMap because repeated ID lookups scale much better.
     *
     * Finding all overdue accounts:
     * Nested pairwise comparison = O(n^2); single pass with a Set = O(n) average-case.
     * For 1 million accounts, choose the single-pass Set approach because O(n) scales better.
     */
}
