package com.totvs.sl.school.query.professor.repository.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.sl.school.query.professor.amqp.events.ProfessorCriadoEvent;
import com.totvs.sl.school.query.professor.repository.ProfessorModel;
import com.totvs.sl.school.query.professor.repository.ProfessorRepository;

@Service
@Transactional
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;

	public void handle(ProfessorCriadoEvent event) {
		ProfessorModel professor = ProfessorModel.builder()
		                                         .id(event.getProfessorId())
		                                         .nome(event.getNome())
		                                         .cpf(event.getCpf())
		                                         .email(event.getEmail())
		                                         .titulacao(event.getTitulacao())
		                                         .build();
		repository.save(professor);
	}
}
