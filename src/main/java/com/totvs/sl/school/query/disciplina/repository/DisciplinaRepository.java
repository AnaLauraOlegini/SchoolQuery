package com.totvs.sl.school.query.disciplina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, String>,
        PagingAndSortingRepository<Disciplina, String>, ApiJpaRepository<Disciplina> {

}
