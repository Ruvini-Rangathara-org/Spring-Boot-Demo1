package com.example.SpringBootDevStack.dto.response.paginated;

import com.example.SpringBootDevStack.dto.response.ResponseDoctorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedDoctorResponseDto {
    private long count;
    private List<ResponseDoctorDto> list;
}
