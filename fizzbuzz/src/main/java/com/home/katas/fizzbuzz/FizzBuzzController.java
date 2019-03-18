package com.home.katas.fizzbuzz;

import com.home.katas.fizzbuzz.helpers.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class FizzBuzzController {

    private FizzBuzz fizzBuzz;
    private Randomizer randomizer;

    @Autowired
    FizzBuzzController(FizzBuzz fizzBuzz, Randomizer randomizer){
        this.fizzBuzz = fizzBuzz;
        this.randomizer = randomizer;
    }

    @RequestMapping(value="/sequence/{from}/{to}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public FizzBuzzResponse getNumberSequence(@PathVariable int from,
                                    @PathVariable int to){
        String result = fizzBuzz.print(from, to);

         return new FizzBuzzResponse(result);
    }

    @RequestMapping(value="/sequence/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FizzBuzzResponse getNumberSequence(@RequestBody FizzBuzzRequest request){
        String result = fizzBuzz.print(request.getFrom(), request.getTo());

        return new FizzBuzzResponse(result);
    }

    @RequestMapping(value="/sequence/size/{size}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FizzBuzzResponse getRandomNumberSequence(@PathVariable int size){
        System.out.println();
        String result = fizzBuzz.print(randomizer.generateSequence(size));
        return new FizzBuzzResponse(result);
    }


}
