package com.example.SpringBootDevStack.service.impl;

import com.example.SpringBootDevStack.dto.request.RequestDoctorDto;
import com.example.SpringBootDevStack.dto.response.ResponseDoctorDto;
import com.example.SpringBootDevStack.entity.DoctorEntity;
import com.example.SpringBootDevStack.repo.DoctorRepo;
import com.example.SpringBootDevStack.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        DoctorEntity doctorEntity = doctorRepo.getReferenceById(id);
        ResponseDoctorDto responseDoctorDto = new ResponseDoctorDto(
                doctorEntity.getId(),
                doctorEntity.getName(),
                doctorEntity.getAddress(),
                doctorEntity.getContact(),
                doctorEntity.getSalary()
        );
        return responseDoctorDto;
    }

    @Override
    public void deleteDoctor(long id) {
        doctorRepo.deleteById(id);
    }

    @Override
    public void updateDoctor(long id, RequestDoctorDto doctorDto) {
        DoctorEntity doctorEntity = new DoctorEntity(
                id,
                doctorDto.getName(),
                doctorDto.getAddress(),
                doctorDto.getContact(),
                doctorDto.getSalary()
        );
        doctorRepo.save(doctorEntity);
    }

    @Override
    public List<ResponseDoctorDto> getAllDoctors(String searchText, int page, int size) {
        List<DoctorEntity> all = doctorRepo.findAll();
        List<ResponseDoctorDto> list = new ArrayList<>();
        for (DoctorEntity entity: all) {
            list.add(new ResponseDoctorDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getContact(),
                    entity.getSalary()
            ));
        }
        return list;
    }
}
