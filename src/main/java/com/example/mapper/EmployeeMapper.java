package com.example.mapper;

import com.example.dto.DepartmentDto;
import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto mapEmployeeDto(Employee employee) {
        DepartmentDto departmentDto = DepartmentDto.builder()
                .id(employee.getDepartment().getId())
                .code(employee.getDepartment().getCode())
                .description(employee.getDepartment().getDescription())
                .build();

        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .salary(employee.getSalary())
                .department(departmentDto)
                .build();
    }

    public Employee mapEmployee(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .salary(employeeDto.getSalary())
                .build();
    }
}
