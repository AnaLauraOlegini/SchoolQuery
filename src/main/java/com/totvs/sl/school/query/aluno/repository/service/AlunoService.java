package com.totvs.sl.school.query.aluno.repository.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.sl.school.query.aluno.amqp.events.AlunoCriadoEvent;
import com.totvs.sl.school.query.aluno.repository.AlunoModel;
import com.totvs.sl.school.query.aluno.repository.AlunoRepository;

@Service
@Transactional
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public void handle(AlunoCriadoEvent event) {
		AlunoModel aluno = AlunoModel.builder()
				.id(event.getAlunoId())
				.nome(event.getNome())
				.cpf(event.getCpf())
				.email(event.getEmail())
				.formaIngresso(event.getFormaIngresso())
				.matricula(event.getMatricula())
				.build();
		repository.save(aluno);
	}
}