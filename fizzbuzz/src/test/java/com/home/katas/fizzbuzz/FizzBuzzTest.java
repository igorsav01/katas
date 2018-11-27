package com.home.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void print_printsIntegers_betweenFrom_andTo(){
        String result = fizzBuzz.print(1, 10);
        String expectation = "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz";
        assertThat(result, equalTo(expectation));
    }

    @Test(expected=RuntimeException.class)
    public void print_whenFrom_isGreater_thanTo_thenError(){
        fizzBuzz.print(10, 5);
    }

    @Test(expected=RuntimeException.class)
    public void print_whenFrom_isSame_asTo_thenError(){
        fizzBuzz.print(10, 10);
    }

    @Test
    public void print_whenNumberIsDivisibleBy3_thenPrintsFizz(){
        String result = fizzBuzz.print(2, 6);
        assertThat(result, equalTo("2,fizz,4,buzz,fizz"));
    }

    @Test
    public void print_whenNumberIsDivisibleBy5_thenPrintsBuzz(){
        String result = fizzBuzz.print(4, 11);
        assertThat(result, equalTo("4,buzz,fizz,7,8,fizz,buzz,11"));
    }

    @Test
    public void print_whenNumberIsDivisibleBy5_And3_thenPrintsBuzz(){
        String result = fizzBuzz.print(9, 16);
        assertThat(result, equalTo("fizz,buzz,11,fizz,13,14,buzz,16"));
    }


}