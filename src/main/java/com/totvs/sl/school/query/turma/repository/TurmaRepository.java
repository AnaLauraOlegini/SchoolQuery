package com.totvs.sl.school.query.turma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.totvs.tjf.api.jpa.repository.ApiJpaRepository;

@Repository
public interface TurmaRepository
        extends JpaRepository<Turma, String>, PagingAndSortingRepository<Turma, String>, ApiJpaRepository<Turma> {

}
