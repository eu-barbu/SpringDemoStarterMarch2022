package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping(value="/index")
    public String getIndex(Model model){

        String greetingText = "Hello World!";

        model.addAttribute("greetings", greetingText);
        model.addAttribute("someText", 3);

        List<Employee> employeeList = List.of(
                new Employee("Max", "Mustermann", 500),
                new Employee("Andrei", "Popescu", 650),
                new Employee("George", "Georgescu", 700)
        );

        model.addAttribute("employeeList", employeeList);

        return "indexPage";
    }

}
