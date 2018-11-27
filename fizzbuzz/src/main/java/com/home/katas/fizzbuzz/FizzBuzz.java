package com.home.katas.fizzbuzz;

import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {
    public String print(int from, int to) {
        if(from >= to){
            throw new RuntimeException("From cannot be greater than To");
        }
        StringBuilder result = new StringBuilder();
        for (int i = from; i <= to; i++) {
            if(i%5 == 0){
                result.append("buzz,");
                continue;
            }
            if(i%3 == 0){
                result.append("fizz,");
                continue;
            }
            result.append(String.format("%d,", i));
        }
        return result.toString().substring(0, result.length()-1);
    }
}
