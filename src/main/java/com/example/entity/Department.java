package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_department")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String code;

    @Column
    private String description;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Employee> employeeList;
}
