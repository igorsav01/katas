package com.home.katas.fizzbuzz.helpers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RandomizerTest {

    private Randomizer randomizer;

    @Before
    public void setUp(){
        randomizer = new Randomizer();
    }

    @Test
    public void generateSequence_returnsArrayOfSpecifiedSize(){
        int[]result = randomizer.generateSequence(10);

        assertThat(result.length, equalTo(10));
    }

}