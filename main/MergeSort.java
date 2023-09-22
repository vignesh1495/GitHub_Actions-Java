package main;

import java.util.stream.IntStream;

/**
 * Recursively sorts a subarray of integers using the merge sort algorithm.
 *
 * @param left  The left index of the subarray to be sorted.
 * @param right The right index of the subarray to be sorted.
 * @param array The array containing the subarray to be sorted.
 */

public class MergeSort {
    // Define named constants
    private static final int[] INPUT_ARRAY = {4, 2, 1, 3, 5};
    private static final int ARRAY_LENGTH = INPUT_ARRAY.length;

    public static void main(String[] args) {
        int[] array = INPUT_ARRAY.clone(); // Clone the input array to avoid modifying it
        mergeNewSort(0, ARRAY_LENGTH - 1, array);
        IntStream.of(array).forEach(e -> System.out.println(e));
    }

    private static void mergeNewSort(int left, int right, int[] array) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeNewSort(left, middle, array);
        mergeNewSort(middle + 1, right, array);
        sortMergeArray(left, middle, right, array);
    }

    private static void sortMergeArray(int left, int middle, int right, int[] array) {
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
