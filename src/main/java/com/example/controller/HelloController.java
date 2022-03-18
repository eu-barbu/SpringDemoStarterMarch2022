package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value="/sayHello")
    @ResponseBody
    public String printHello(){
        return "Hello World!";
    }

    @GetMapping(value="/printParam")
    @ResponseBody
    public String printParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @GetMapping(value="/printPathVar/{location}/products")
    @ResponseBody
    public String printPathVar(@PathVariable String location, @RequestParam String name){
        return "Showing productis for region: " + location + " " + name;
    }

    @GetMapping(value="/createEmployees")
    @ResponseBody
    public List<Employee> createEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return List.of(new Employee(firstName, lastName, 300),
                new Employee("aa", "bb", 500),
                new Employee("aa", "ss", 600),
                new Employee("jj", "kk", 650)
                );
    }

}
