package com.example.dto;

import lombok.*;

@NoArgsConstructor
@Builder
@Getter
@Setter
@AllArgsConstructor
public class DepartmentDto {

    private int id;
    private String code;
    private String description;
}
