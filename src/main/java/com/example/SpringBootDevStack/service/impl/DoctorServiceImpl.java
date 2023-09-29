package com.example.SpringBootDevStack.service.impl;

import com.example.SpringBootDevStack.dto.request.RequestDoctorDto;
import com.example.SpringBootDevStack.dto.response.ResponseDoctorDto;
import com.example.SpringBootDevStack.entity.DoctorEntity;
import com.example.SpringBootDevStack.repo.DoctorRepo;
import com.example.SpringBootDevStack.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void createDoctor(RequestDoctorDto doctorDto) {

        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();

        DoctorEntity doctorEntity = new DoctorEntity(
                mostSignificantBits, doctorDto.getName(),doctorDto.getAddress(), doctorDto.getContact(),
                doctorDto.getSalary()
        );
        doctorRepo.save(doctorEntity);
    }

    @Override
    public ResponseDoctorDto getDoctor(long id) {
        return null;
    }

    @Override
    public void deleteDoctor(long id) {

    }

    @Override
    public void updateDoctor(long id, RequestDoctorDto doctorDto) {

    }

    @Override
    public List<ResponseDoctorDto> getAllDoctors(String searchText, int page, int size) {
        return null;
    }
}
