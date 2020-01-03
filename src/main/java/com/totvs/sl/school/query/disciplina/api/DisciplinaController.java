package com.totvs.sl.school.query.disciplina.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.sl.school.query.disciplina.api.dto.DisciplinaDTO;
import com.totvs.sl.school.query.disciplina.exception.SchoolDisciplinaNotFoundException;
import com.totvs.sl.school.query.disciplina.repository.Disciplina;
import com.totvs.sl.school.query.disciplina.repository.DisciplinaRepository;
import com.totvs.sl.school.query.professor.repository.ProfessorRepository;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(path = DisciplinaController.PATH, produces = { APPLICATION_JSON_VALUE })
@ApiGuideline(ApiGuidelineVersion.v1)
public class DisciplinaController {

	public static final String PATH = "/api/v1/disciplinas";

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@ApiOperation(value = "Retorna uma disciplina.", httpMethod = "GET")
	@GetMapping(path = "/{id}")
	public DisciplinaDTO getDisciplinaById(@PathVariable String id) {
		return this.disciplinaRepository.findById(id)
		                                .map(this::disciplinaDTO)
		                                .stream()
		                                .findFirst()
		                                .orElseThrow(() -> { throw new SchoolDisciplinaNotFoundException(); });
	}

	private DisciplinaDTO disciplinaDTO(Disciplina disciplina) {
		return DisciplinaDTO.builder()
		                    .id(disciplina.getId())
		                    .descricao(disciplina.getDescricao())
		                    .sigla(disciplina.getSigla())
		                    .cargaHoraria(disciplina.getCargaHoraria())
		                    .professorId(disciplina.getProfessorId()
		                                           .stream()
		                                           .map(String::valueOf)
		                                           .collect(Collectors.toList()))
		                    .build();
	}

}
