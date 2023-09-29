package com.example.SpringBootDevStack.api;

import com.example.SpringBootDevStack.dto.request.RequestDoctorDto;
import com.example.SpringBootDevStack.dto.response.ResponseDoctorDto;
import com.example.SpringBootDevStack.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping
    public String createDoctor(@RequestBody RequestDoctorDto doctorDto){
        doctorService.createDoctor(doctorDto);
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
        ResponseDoctorDto doctor = doctorService.getDoctor(Long.parseLong(id));
        return "Find Doctor   ->   "+doctor.toString();

        //http://localhost:8000/api/v1/doctors/D0001            -> GET
    }

    @PutMapping(params = "id")
    public String updateDoctor(@RequestParam String id, @RequestBody RequestDoctorDto doctorDto){
        doctorService.updateDoctor(Long.parseLong(id),doctorDto);
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
        doctorService.deleteDoctor(Long.parseLong(id));
        return "Delete Doctor    ->  "+id;

        //http://localhost:8000/api/v1/doctors/D0001            -> DELETE
    }

    @GetMapping(path = "/list" , params = {"searchText", "page", "size"})
    public String findAllDoctors(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        List<ResponseDoctorDto> allDoctors = doctorService.getAllDoctors(searchText, page, size);
        return "All Doctors   -> \n"+allDoctors.toString();
        //http://localhost:8000/api/v1/doctors/list?searchText=ruvini&page=0&size=10
    }

}
