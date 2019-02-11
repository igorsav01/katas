package com.home.katas.fizzbuzz.useCases;

public class mergeSort {

    private void merge(int[] arr, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        System.arraycopy(arr, left, leftArray, 0, leftSize);

        for (int j = 0; j < rightSize; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void sort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sort(arr, start, middle);
            sort(arr, middle + 1, end);

            merge(arr, start, middle, end);
        }
    }
}