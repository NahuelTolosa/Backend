package com.coderhouse.controlleradvice.controller;

import com.coderhouse.controlleradvice.handle.FirstApplicationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping
    public String sayHello(){
        return "Hello";
    }

    @GetMapping(value = "/{id}")
    public String sendMessage(@PathVariable int id) throws FirstApplicationException {

        if(id<=0 || id>=3){
            throw new FirstApplicationException("Error. Número fuera del intervalo permitido.");
        }

        return showMessage(id);
    }

    private String showMessage(int option) {

        switch(option){
            case 1:
                return "Hello";

            case 2:
                return "Bye";
        }
        return null;
    }
}
