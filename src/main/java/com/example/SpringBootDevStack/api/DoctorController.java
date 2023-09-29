package com.example.SpringBootDevStack.api;

import com.example.SpringBootDevStack.dto.request.RequestDoctorDto;
import com.example.SpringBootDevStack.dto.response.ResponseDoctorDto;
import com.example.SpringBootDevStack.service.DoctorService;
import com.example.SpringBootDevStack.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StandardResponse> createDoctor(@RequestBody RequestDoctorDto doctorDto){
        doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Doctor was saved!",doctorDto.toString()),
                HttpStatus.CREATED
        );

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
    public ResponseEntity<StandardResponse> findDoctor(@PathVariable String id){
        ResponseDoctorDto doctor = doctorService.getDoctor(Long.parseLong(id));
        return new ResponseEntity<>(
                new StandardResponse(200,"Doctor was found!",doctorService.getDoctor(Long.parseLong(id))),
                HttpStatus.OK
        );

        //http://localhost:8000/api/v1/doctors/D0001            -> GET
    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateDoctor(@RequestParam String id, @RequestBody RequestDoctorDto doctorDto){
        doctorService.updateDoctor(Long.parseLong(id),doctorDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Updated Doctor Data!", doctorDto.toString()),
                HttpStatus.OK
        );

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
    public ResponseEntity<StandardResponse> deleteDoctor(@PathVariable String id){
        doctorService.deleteDoctor(Long.parseLong(id));
        return new ResponseEntity<>(
                new StandardResponse(204,"Deleted Doctor Data!", id),
                HttpStatus.NO_CONTENT
        );

        //http://localhost:8000/api/v1/doctors/D0001            -> DELETE
    }

    @GetMapping(path = "/list" , params = {"searchText", "page", "size"})
    public ResponseEntity<StandardResponse> findAllDoctors(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(200,"Doctor Data List! ", doctorService.getAllDoctors(searchText, page, size)),
                HttpStatus.OK
        );

        //http://localhost:8000/api/v1/doctors/list?searchText=ruvini&page=0&size=10
    }

}
