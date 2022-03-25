package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_employee")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "monthly_salary")
    private int salary;

    @Column(name = "document")
    private String document;

    @ManyToOne
    @JoinColumn(name = "id_department")
    private Department department;
}
