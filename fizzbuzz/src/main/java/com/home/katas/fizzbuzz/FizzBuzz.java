package com.home.katas.fizzbuzz;

import com.home.katas.fizzbuzz.useCases.QuickSort;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {

    private QuickSort quickSort;

    public FizzBuzz(QuickSort quickSort){

        this.quickSort = quickSort;
    }

    public String print(int from, int to) {
        if(from >= to){
            throw new RuntimeException("From cannot be greater than To");
        }
        return fizzBuzzNumbers(from, to);
    }
    public String print(int[] unsortedArray){
        return fizzBuzzSortedArray(quickSort.sortArray(unsortedArray));
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
