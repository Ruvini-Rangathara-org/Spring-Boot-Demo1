package com.example.SpringBootDevStack.util.mapper;


import com.example.SpringBootDevStack.dto.request.RequestDoctorDto;
import com.example.SpringBootDevStack.dto.response.ResponseDoctorDto;
import com.example.SpringBootDevStack.entity.DoctorEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface DoctorMapper {
    ResponseDoctorDto toResponseDoctorDto(DoctorEntity doctorEntity);
    DoctorEntity toDoctorEntity(RequestDoctorDto requestDoctorDto);
    List<ResponseDoctorDto> toResponseDoctorDtoList(List<DoctorEntity> list);
}
