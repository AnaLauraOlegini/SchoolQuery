package com.totvs.sl.school.query.professor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, String>,
        PagingAndSortingRepository<ProfessorModel, String>, ApiJpaRepository<ProfessorModel> {

	Optional<ProfessorModel> getByCpf(String cpf);

	Optional<ProfessorModel> getById(String id);

}
