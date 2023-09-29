package com.example.SpringBootDevStack.service;

import com.example.SpringBootDevStack.dto.request.RequestDoctorDto;
import com.example.SpringBootDevStack.dto.response.ResponseDoctorDto;
import com.example.SpringBootDevStack.dto.response.paginated.PaginatedDoctorResponseDto;

import java.util.List;

public interface DoctorService {
    void createDoctor(RequestDoctorDto doctorDto);
    ResponseDoctorDto getDoctor(long id);
    void deleteDoctor(long id);
    void updateDoctor(long id, RequestDoctorDto doctorDto);
    PaginatedDoctorResponseDto getAllDoctors(String searchText, int page, int size);
    List<ResponseDoctorDto> getAllByName(String name);


}
