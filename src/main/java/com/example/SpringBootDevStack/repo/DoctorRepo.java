package com.example.SpringBootDevStack.repo;

import com.example.SpringBootDevStack.entity.DoctorEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface DoctorRepo extends JpaRepository<DoctorEntity, Long>{
    List<DoctorEntity> findAllByName(String name);

    @Query(value = "SELECT * FROM doctor WHERE name LIKE ?1 OR address LIKE ?1", nativeQuery = true)
    List<DoctorEntity> searchDoctors(String searchText, PageRequest pageable);
}
