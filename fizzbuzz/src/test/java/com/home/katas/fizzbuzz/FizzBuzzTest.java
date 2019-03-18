package com.home.katas.fizzbuzz;

import com.home.katas.fizzbuzz.useCases.MergeSort;
import com.home.katas.fizzbuzz.useCases.QuickSort;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    private int[] randomSequence;

    @Mock
    private QuickSort quickSort;

    @Mock
    private MergeSort mergeSort;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        randomSequence = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        fizzBuzz = new FizzBuzz(quickSort, mergeSort);
    }

    @Test
    public void print_printsIntegers_betweenFrom_andTo() {
        String result = fizzBuzz.print(1, 10);
        String expectation = "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz";
        assertThat(result, equalTo(expectation));
    }

    @Test(expected = RuntimeException.class)
    public void print_whenFrom_isGreater_thanTo_thenError() {
        fizzBuzz.print(10, 5);
    }

    @Test(expected = RuntimeException.class)
    public void print_whenFrom_isSame_asTo_thenError() {
        fizzBuzz.print(10, 10);
    }

    @Test
    public void print_whenNumberIsDivisibleBy3_thenPrintsFizz() {
        String result = fizzBuzz.print(2, 6);
        assertThat(result, equalTo("2,fizz,4,buzz,fizz"));
    }

    @Test
    public void print_whenNumberIsDivisibleBy5_thenPrintsBuzz() {
        String result = fizzBuzz.print(4, 11);
        assertThat(result, equalTo("4,buzz,fizz,7,8,fizz,buzz,11"));
    }

    @Test
    public void print_whenNumberIsDivisibleBy5_And3_thenPrintsBuzz() {
        String result = fizzBuzz.print(9, 16);
        assertThat(result, equalTo("fizz,buzz,11,fizz,13,14,buzz,16"));
    }

    @Test
    public void print_whenPassedArray_Sorts_AndPrints() {
        int[] sortedSequence = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        when(quickSort.sortArray(randomSequence)).thenReturn(sortedSequence);

        String result = fizzBuzz.print(randomSequence);
        verify(quickSort, times(1)).sortArray(randomSequence);

        assertThat(result, equalTo("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz"));
    }


}