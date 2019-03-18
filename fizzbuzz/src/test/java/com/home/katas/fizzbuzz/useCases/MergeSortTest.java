package com.home.katas.fizzbuzz.useCases;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MergeSortTest {

    private MergeSort mergeSort;

    @Before
    public void setUp(){
        mergeSort = new MergeSort();
    }

    @Test
    public void sort_Arranges_arrayInAscendingOrder(){
        int[] input = new int[] { 3,5,7,9,2,4,6,8,1};
        int[] expected = new int[] { 1,2,3,4,5,6,7,8,9};

        mergeSort.sort(input, 0, input.length-1);

        assertThat(input, equalTo(expected));
    }

}