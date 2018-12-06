package com.home.katas.fizzbuzz.useCases;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class quickSortTest {

    private QuickSort quickSort;

    @Before
    public void setUp(){
        this.quickSort = new QuickSort();
    }

    @Test
    public void whenPartition_placesLastElement_atItsCorrectPosition(){
        int[] array = new int[]{3, 7, 2, 5, 4};

        int nextLow = quickSort.partition(array, 1, array.length - 1);

        assertThat(nextLow, equalTo(2));
        assertThat(array[2], equalTo(4));
    }

    @Test
    public void whenPartition_placesAllSmallerElements_toTheLeftOfPivot(){
        int[] array = new int[]{3, 7, 2, 8, 4};

        quickSort.partition(array, 1, array.length - 1);

        assertThat(array, equalTo(new int[]{3,2,4,8,7}));
    }

    @Test
    public void whenSort_returnsSortedArray(){
        int[] array = new int[]{3, 7, 2, 8, 4};

        quickSort.sort(array, 0, array.length - 1);

        assertThat(array, equalTo(new int[]{2,3,4,7,8}));
    }

    @Test
    public void whenSort_andStartGreaterThanEnd_doesNothing(){
        int[] array = new int[]{3, 7, 2, 8, 4};

        quickSort.sort(array, 4, 3);

        assertThat(array, equalTo(new int[]{3, 7, 2, 8, 4}));
    }


}