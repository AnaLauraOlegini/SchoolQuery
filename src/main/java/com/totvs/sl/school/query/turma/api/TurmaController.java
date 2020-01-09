package com.totvs.sl.school.query.turma.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.sl.school.query.turma.api.dto.TurmaDTO;
import com.totvs.sl.school.query.turma.exception.SchoolTurmaNotFoundException;
import com.totvs.sl.school.query.turma.repository.Turma;
import com.totvs.sl.school.query.turma.repository.TurmaRepository;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(path = TurmaController.PATH, produces = { APPLICATION_JSON_VALUE })
@ApiGuideline(ApiGuidelineVersion.v1)
public class TurmaController {

	public static final String PATH = "api/v1/turmas";

	@Autowired
	private TurmaRepository turmaRepository;

	@ApiOperation(value = "Retorna uma turma.", httpMethod = "GET")
	@GetMapping(path = "/{id}")
	public TurmaDTO getTurmaById(@PathVariable String id) {
		return this.turmaRepository.findById(id)
		                           .map(this::turmaDTO)
		                           .stream()
		                           .findFirst()
		                           .orElseThrow(() -> { throw new SchoolTurmaNotFoundException(); });
	}

	private TurmaDTO turmaDTO(Turma turma) {
		return TurmaDTO.builder()
		               .id(turma.getId())
		               .descricao(turma.getDescricao())
		               .anoLetivo(turma.getAnoLetivo())
		               .periodoLetivo(turma.getPeriodoLetivo())
		               .numeroVagas(turma.getNumeroVagas())
		               .disciplinaId(turma.getDisciplinaId().stream().map(String::valueOf).collect(Collectors.toList()))
		               .alunoId(turma.getAlunoId().stream().map(String::valueOf).collect(Collectors.toList()))
		               .build();
	}
}