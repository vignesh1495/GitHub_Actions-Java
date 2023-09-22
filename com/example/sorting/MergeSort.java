package com.example.sorting;

import java.util.stream.IntStream;

/**
 * This class demonstrates the Merge Sort algorithm.
 */
public final class MergeSort {

    private MergeSort() {
        // Private constructor to prevent instantiation
    }

    /**
     * Main method to test the Merge Sort algorithm.
     *
     * @param args The command-line arguments.
     */
    public static void main(final String[] args) {
        int[] array = new int[]{4, 2, 1, 3, 5};
        mergeNewSort(0, array.length - 1, array);
        IntStream.of(array).forEach(e -> System.out.println(e));
    }

    /**
     * Sorts an array using the Merge Sort algorithm.
     *
     * @param left  The left index of the array.
     * @param right The right index of the array.
     * @param array The array to be sorted.
     */
    private static void mergeNewSort(final int left, final int right, final int[] array) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeNewSort(left, middle, array);
        mergeNewSort(middle + 1, right, array);
        sortMergeArray(left, middle, right, array);
    }

    /**
     * Merges two sorted subarrays into a single sorted array.
     *
     * @param left    The left index of the subarray.
     * @param middle  The middle index of the subarray.
     * @param right   The right index of the subarray.
     * @param array   The array containing the subarrays to be merged.
     */
    private static void sortMergeArray(final int left, final int middle, final int right, final int[] array) {
        int[] mergeArray = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                mergeArray[k++] = array[i++];
            } else {
                mergeArray[k++] = array[j++];
            }
        }
        while (i <= middle) {
            mergeArray[k++] = array[i++];
        }
        while (j <= right) {
            mergeArray[k++] = array[j++];
        }
        for (int v = left; v <= right; v++) {
            array[v] = mergeArray[v - left];
        }
    }
}
