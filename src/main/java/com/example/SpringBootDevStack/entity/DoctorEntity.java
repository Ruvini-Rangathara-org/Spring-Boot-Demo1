package com.example.SpringBootDevStack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "doctor")
public class DoctorEntity {
    @Id
    private long id;
    private String name;
    private String address;
    private String contact;
    private double salary;
}
