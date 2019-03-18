package com.home.katas.fizzbuzz;

import com.home.katas.fizzbuzz.useCases.MergeSort;
import com.home.katas.fizzbuzz.useCases.QuickSort;
import com.home.katas.fizzbuzz.useCases.Sort;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class FizzBuzz {

    private Sort quickSort;
    private Sort mergeSort;

    public FizzBuzz(QuickSort quickSort, MergeSort mergeSort){
        this.quickSort = quickSort;
        this.mergeSort = mergeSort;
    }

    public String print(int from, int to) {
        if(from >= to){
            throw new RuntimeException("From cannot be greater than To");
        }
        return fizzBuzzNumbers(from, to);
    }

    public String print(int[] unsortedArray){
        CompletableFuture<int[]> mergeSortFuture = CompletableFuture.supplyAsync(() -> mergeSort.sortArray(unsortedArray.clone()));
        CompletableFuture<int[]> quickSortFuture = CompletableFuture.supplyAsync( () -> quickSort.sortArray(unsortedArray.clone()));

        CompletableFuture<Object> resultFuture = CompletableFuture.anyOf(quickSortFuture, mergeSortFuture);

        //mergeSort.sortArray(unsortedArray.clone());
        //return fizzBuzzSortedArray(quickSort.sortArray(unsortedArray.clone()));
        try {
            return fizzBuzzSortedArray((int[])resultFuture.get());
        }
        catch(Throwable t){
            return t.getMessage();
        }
    }

    private String fizzBuzzNumbers(int from, int to) {
        StringBuilder result = new StringBuilder();
        for (int i = from; i <= to; i++) {
            replace(result, i);
        }
        return result.toString().substring(0, result.length()-1);
    }

    private String fizzBuzzSortedArray(int[] sortedArray) {
        StringBuilder result = new StringBuilder();

        for (int i : sortedArray) {
            replace(result, i);
        }
        return result.toString().substring(0, result.length()-1);
    }

    private void replace(StringBuilder result, int i) {
        if(i%5 == 0){
            result.append("buzz,");
            return;
        }
        if(i%3 == 0){
            result.append("fizz,");
            return;
        }
        result.append(String.format("%d,", i));
    }
}
