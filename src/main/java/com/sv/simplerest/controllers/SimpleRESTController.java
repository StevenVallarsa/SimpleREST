
package com.sv.simplerest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author: Steven Vallarsa
 *   email: stevenvallarsa@gmail.com
 *    date: 2022-01-23
 * purpose: 
 */
@RestController
@RequestMapping("/api")
public class SimpleRESTController {

    @GetMapping
    public String[] helloWorld() {
        String[] result = {"Hello", "World", "!"};
        return result;
    }
    
    @PostMapping("/calculate")
    public String calculate(int operand1, String operator, int operand2) {
        int result = 0;
        switch(operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                String message = String.format("operator '%s' is invalid", operator);
                throw new IllegalArgumentException(message);
                
        }
        return String.format("%s %s %s = %s", operand1, operator, operand2, result);
    }
    
    @DeleteMapping("/resource/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable int id) {
      return String.valueOf(id);
    }
    

}
