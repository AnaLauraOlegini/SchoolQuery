package com.totvs.sl.school.query.aluno.exception;

import com.totvs.tjf.api.context.stereotype.ApiErrorParameter;
import com.totvs.tjf.api.context.stereotype.error.ApiNotFound;

import lombok.Getter;

@ApiNotFound("SchoolAlunoNotFoundException")
@Getter
public class SchoolAlunoNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2100396918453973429L;

	@ApiErrorParameter
	private final String aluno;
	
	public SchoolAlunoNotFoundException(String aluno) {
		this.aluno = aluno;
	}
	
}
