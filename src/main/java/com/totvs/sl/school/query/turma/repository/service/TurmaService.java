package com.totvs.sl.school.query.turma.repository.service;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.sl.school.query.turma.amqp.events.TurmaCriadaEvent;
import com.totvs.sl.school.query.turma.repository.Turma;
import com.totvs.sl.school.query.turma.repository.TurmaAlunoTurma;
import com.totvs.sl.school.query.turma.repository.TurmaDisciplinaTurma;
import com.totvs.sl.school.query.turma.repository.TurmaRepository;

@Service
@Transactional
public class TurmaService {

	@Autowired
	private TurmaRepository repository;

	public void handle(TurmaCriadaEvent event) {

		Turma turma = Turma.builder()
		                   .id(event.getTurmaId())
		                   .descricao(event.getDescricao())
		                   .anoLetivo(event.getAnoLetivo())
		                   .periodoLetivo(event.getPeriodoLetivo())
		                   .numeroVagas(event.getNumeroVagas())
		                   .disciplinaId(event.getDisciplinaId()
		                                      .stream()
		                                      .map(TurmaDisciplinaTurma::of)
		                                      .collect(Collectors.toList()))
		                   .alunoId(event.getAlunoId().stream().map(TurmaAlunoTurma::of).collect(Collectors.toList()))
		                   .build();

		repository.save(turma);
	}
}
