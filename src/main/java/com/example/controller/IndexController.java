package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    EmployeeService service;

    @GetMapping(value="/index")
    public String getIndex(Model model){
        String greetingText = "Hello World!";

        model.addAttribute("greetings", greetingText);
        model.addAttribute("someText", 3);

        model.addAttribute("employeeList", service.getEmployeeList());

        return "indexPage";
    }

    @GetMapping(value="/createEmployee")
    public String createEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "formPage";
    }

    @PostMapping(value="/submitEmployee")
    public String submitEmployee(@ModelAttribute Employee employee){
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getSalary());
        service.saveEmployee(employee);

        return "redirect:/index";
    }
}
