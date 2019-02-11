package com.home.katas.fizzbuzz.useCases;

import org.springframework.stereotype.Component;

@Component
public class QuickSort {

    /* This function takes last element as pivot,
           places the pivot element at its correct
           position in sorted array, and places all
           smaller (smaller than pivot) to left of
           pivot and all greater elements to right
           of pivot */
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(int[] arr, int start, int end)
    {
        if (start < end)
        {
            int pi = partition(arr, start, end);

            sort(arr, start, pi-1);
            sort(arr, pi+1, end);
        }
    }

    public int[] sortArray(int[] arrayToSort){
        sort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }
}