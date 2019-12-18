package com.totvs.sl.school.query.professor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, String>{

    Optional<ProfessorModel> getByCpf(String cpf);
    
}
