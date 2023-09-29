package com.example.SpringBootDevStack.api;

import com.example.SpringBootDevStack.dto.request.RequestDoctorDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @PostMapping
    public String createDoctor(@RequestBody RequestDoctorDto doctorDto){
        return doctorDto.toString();
        //http://localhost:8000/api/v1/doctors -> POST

        // Body -> raw
        // {
        //    "name": "ruvini",
        //    "address": "panadura",
        //    "contact":"0786628489",
        //    "salary":60000
        //}
    }

    @GetMapping("/{id}")
    public String findDoctor(@PathVariable String id){
        return "Find Doctor   ->   "+id;
        //http://localhost:8000/api/v1/doctors/D0001            -> GET
    }

    @PutMapping(params = "id")
    public String updateDoctor(@RequestParam String id, @RequestBody RequestDoctorDto doctorDto){
        return "Update Doctor   ->  "+doctorDto.toString();

        //http://localhost:8000/api/v1/doctors?id=D0001            -> PUT
        //Params  (QueryParams)
        //id               D0001


        // Body -> raw
        // {
        //    "name": "ruvini",
        //    "address": "panadura",
        //    "contact":"0786628489",
        //    "salary":60000
        //}
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable String id){
        return "Delete Doctor    ->  "+id;

        //http://localhost:8000/api/v1/doctors/D0001            -> DELETE
    }

    @GetMapping(path = "/list" , params = {"searchText", "page", "size"})
    public String findAllDoctors(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return "All Doctors";
        //http://localhost:8000/api/v1/doctors/list?searchText=ruvini&page=0&size=10
    }

}
