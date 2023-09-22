package com.example.sorting;


import java.util.stream.IntStream;

/**
 * MergeSort is a sorting algorithm that uses the divide and conquer approach to sort an array of integers.
 */
public class MergeSort {

    private static final int ARRAY_SIZE = 5;
    private static final int DEFAULT_VALUE = 0;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        array[0] = 4;
        array[1] = 2;
        array[2] = 1;
        array[3] = 3;
        array[4] = 5;

        mergeSort(0, ARRAY_SIZE - 1, array);

        IntStream.of(array).forEach(e -> System.out.println(e));
    }

    private static void mergeSort(int left, int right, int[] array) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(left, middle, array);
        mergeSort(middle + 1, right, array);
        merge(left, middle, right, array);
    }

    private static void merge(int left, int middle, int right, int[] array) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        // Copy sorted elements from temp back to the original array
        for (int m = 0; m < temp.length; m++) {
            array[left + m] = temp[m];
        }
    }
}

