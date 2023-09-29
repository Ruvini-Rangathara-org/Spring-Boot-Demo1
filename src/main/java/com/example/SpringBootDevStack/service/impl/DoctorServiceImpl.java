package com.example.SpringBootDevStack.service.impl;

import com.example.SpringBootDevStack.dto.request.RequestDoctorDto;
import com.example.SpringBootDevStack.dto.response.ResponseDoctorDto;
import com.example.SpringBootDevStack.dto.response.paginated.PaginatedDoctorResponseDto;
import com.example.SpringBootDevStack.entity.DoctorEntity;
import com.example.SpringBootDevStack.exception.EntryNotFoundException;
import com.example.SpringBootDevStack.repo.DoctorRepo;
import com.example.SpringBootDevStack.service.DoctorService;
import com.example.SpringBootDevStack.util.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorMapper doctorMapper;

    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorServiceImpl(DoctorMapper doctorMapper, DoctorRepo doctorRepo) {
        this.doctorMapper = doctorMapper;
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
        Optional<DoctorEntity> doctorById = doctorRepo.findById(id);
        if(doctorById.isEmpty()){
            throw new EntryNotFoundException("Doctor Not Found!");
        }
        return doctorMapper.toResponseDoctorDto(doctorById.get());
    }

    @Override
    public void deleteDoctor(long id) {
        Optional<DoctorEntity> byId = doctorRepo.findById(id);
        if(byId.isEmpty()){
            throw new EntryNotFoundException("Doctor Not Found!");
        }
        doctorRepo.deleteById(id);
    }

    @Override
    public void updateDoctor(long id, RequestDoctorDto doctorDto) {
        Optional<DoctorEntity> byId = doctorRepo.findById(id);
        if(byId.isEmpty()){
            throw new EntryNotFoundException("Doctor Not Found!");
        }

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
    public PaginatedDoctorResponseDto getAllDoctors(String searchText, int page, int size) {
        searchText = "%"+searchText+"%";
        List<DoctorEntity> doctorEntities = doctorRepo.searchDoctors(searchText, PageRequest.of(page, size));
        long count = doctorRepo.countDoctors(searchText);

        List<ResponseDoctorDto> list = new ArrayList<>();
        for (DoctorEntity entity: doctorEntities) {
            list.add(doctorMapper.toResponseDoctorDto(entity));
        }
        return new PaginatedDoctorResponseDto(
                count, list
        );
    }

    @Override
    public List<ResponseDoctorDto> getAllByName(String name) {
        List<DoctorEntity> allByName = doctorRepo.findAllByName(name);
        List<ResponseDoctorDto> list = new ArrayList<>();
        for (DoctorEntity entity: allByName) {
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
