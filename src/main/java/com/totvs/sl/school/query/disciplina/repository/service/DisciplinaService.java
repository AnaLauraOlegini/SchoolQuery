package com.totvs.sl.school.query.disciplina.repository.service;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.sl.school.query.disciplina.amqp.events.DisciplinaCriadaEvent;
import com.totvs.sl.school.query.disciplina.repository.Disciplina;
import com.totvs.sl.school.query.disciplina.repository.DisciplinaProfessorDisciplina;
import com.totvs.sl.school.query.disciplina.repository.DisciplinaRepository;

@Service
@Transactional
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;

	public void handle(DisciplinaCriadaEvent event) {

		Disciplina disciplina = Disciplina.builder()
		                                  .id(event.getDisciplinaId())
		                                  .descricao(event.getDescricao())
		                                  .sigla(event.getSigla())
		                                  .cargaHoraria(event.getCargaHoraria())
		                                  .professorId(event.getProfessorId()
		                                                    .stream()
		                                                    .map(DisciplinaProfessorDisciplina::of)
		                                                    .collect(Collectors.toList()))
		                                  .build();

		repository.save(disciplina);
	}
}
