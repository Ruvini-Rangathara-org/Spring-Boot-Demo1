package com.example.SpringBootDevStack.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDoctorDto {
    private String name;
    private String address;
    private String contact;
    private double salary;
}
