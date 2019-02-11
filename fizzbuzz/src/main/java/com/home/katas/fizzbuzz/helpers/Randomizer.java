package com.home.katas.fizzbuzz.helpers;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Randomizer {

    private int limit = 100;

    public int[] generateSequence(int arraySize) {
        int[] sequence = new int[arraySize];
        int index = 0;
        Random random = new Random();
        do{
            sequence[index] = random.nextInt(limit) + 1;
        }while(index++ < arraySize-1);

        return sequence;
    }
}
