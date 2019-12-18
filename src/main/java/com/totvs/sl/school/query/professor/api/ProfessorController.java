package com.totvs.sl.school.query.professor.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.sl.school.query.professor.exception.SchoolProfessorNotFoundException;
import com.totvs.sl.school.query.professor.repository.ProfessorModel;
import com.totvs.sl.school.query.professor.repository.ProfessorRepository;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import com.totvs.tjf.api.context.stereotype.ApiGuideline.ApiGuidelineVersion;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(path = ProfessorController.PATH, produces = {APPLICATION_JSON_VALUE})
@ApiGuideline(ApiGuidelineVersion.v1)
public class ProfessorController {
    
    public static final String PATH = "/api/v1/professores";
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    @ApiOperation(value = "Retorna um professor", httpMethod = "GET")
    @GetMapping(path = "/cpf/{cpf}")
    public ProfessorModel byCpf(@PathVariable String cpf) {
        return this.professorRepository.getByCpf(cpf).orElseThrow(() -> new SchoolProfessorNotFoundException(cpf));
    }
}
