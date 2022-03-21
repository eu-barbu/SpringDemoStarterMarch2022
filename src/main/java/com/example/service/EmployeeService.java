package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.mapper.EmployeeMapper;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper mapper;

    public List<EmployeeDto> getEmployeeList(){
        return employeeRepository.findAll().stream()
                .map(e -> mapper.mapEmployeeDto(e))
                .collect(Collectors.toList());
    }


    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapper.mapEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto findEmployeeById(int id){
        Employee employee = employeeRepository.findById(id).get();
        return mapper.mapEmployeeDto(employee);
    }
}
