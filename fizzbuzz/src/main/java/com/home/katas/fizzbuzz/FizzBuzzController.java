package com.home.katas.fizzbuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class FizzBuzzController {

    private FizzBuzz fizzBuzz;

    @Autowired
    FizzBuzzController(FizzBuzz fizzBuzz){
        this.fizzBuzz = fizzBuzz;
    }

    @RequestMapping(value="/sequence/{from}/{to}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public FizzBuzzResponse getNumberSequence(@PathVariable int from,
                                    @PathVariable int to){
        String result = fizzBuzz.print(from, to);

        FizzBuzzResponse response = new FizzBuzzResponse(result);

        return new FizzBuzzResponse(result);
    }

    @RequestMapping(value="/sequence/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FizzBuzzResponse getNumberSequence(@RequestBody FizzBuzzRequest request){
        String result = fizzBuzz.print(request.getFrom(), request.getTo());

        return new FizzBuzzResponse(result);
    }


}
