package com.totvs.sl.school.query.aluno.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, String> {

	Optional<AlunoModel> getByCpf(String cpf);
}
