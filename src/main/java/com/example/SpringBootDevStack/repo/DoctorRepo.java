package com.example.SpringBootDevStack.repo;

import com.example.SpringBootDevStack.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DoctorRepo extends JpaRepository<DoctorEntity, Long>{

}
