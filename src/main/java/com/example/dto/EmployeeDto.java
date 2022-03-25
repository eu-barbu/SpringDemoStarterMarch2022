package com.example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private int id;
    private String firstName;
    private String lastName;
    private String companyCar;
    private int salary;
    private DepartmentDto department;

}
