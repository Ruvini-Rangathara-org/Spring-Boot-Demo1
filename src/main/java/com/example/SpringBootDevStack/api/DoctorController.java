package com.example.SpringBootDevStack.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @PostMapping
    public String createDoctor(){
        return "Create Doctor";
    }

    @GetMapping
    public String findDoctor(){
        return "Find Doctor";
        //http://localhost:8000/api/v1/doctors
    }

    @PutMapping
    public String updateDoctor(){
        return "Update Doctor";
    }

    @DeleteMapping
    public String deleteDoctor(){
        return "Delete Doctor";
    }

    @GetMapping(path = "/list")
    public String findAllDoctors(){
        return "All Doctors";
        //http://localhost:8000/api/v1/doctors/list
    }

}
