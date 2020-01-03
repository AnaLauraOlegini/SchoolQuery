package com.totvs.sl.school.query.disciplina.exception;

import com.totvs.tjf.api.context.stereotype.error.ApiNotFound;

import lombok.Getter;

@ApiNotFound("SchoolDisciplinaNotFoundException")
@Getter
public class SchoolDisciplinaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2758732768145509557L;

	public SchoolDisciplinaNotFoundException() {
	}
}
