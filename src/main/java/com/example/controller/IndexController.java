package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    EmployeeService service;

    @GetMapping(value="/index")
    public String getIndex(Model model){
        String greetingText = "Hello World!";

        model.addAttribute("greetings", greetingText);
        model.addAttribute("someText", 3);

        List<EmployeeDto> employeeDtoList = service.getEmployeeList();
        model.addAttribute("employeeList", employeeDtoList);

        return "indexPage";
    }

    @GetMapping(value="/createEmployee")
    public String createEmployee(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employee", employeeDto);
        return "formPage";
    }

    @PostMapping(value="/submitEmployee")
    public String submitEmployee(@ModelAttribute EmployeeDto employeeDto){
        service.saveEmployee(employeeDto);

        return "redirect:/index";
    }

    @PostMapping(value="/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        service.deleteEmployee(id);
        return "redirect:/index";
    }

    @PostMapping(value="/editEmployee")
    public String editEmployee(@RequestParam("employeeId") int id, Model model){
        EmployeeDto employeeDto = service.findEmployeeById(id);
        model.addAttribute("employee", employeeDto);
        return "formPage";
    }
}
