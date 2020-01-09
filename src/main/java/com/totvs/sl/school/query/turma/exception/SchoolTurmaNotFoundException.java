package com.totvs.sl.school.query.turma.exception;

import com.totvs.tjf.api.context.stereotype.error.ApiNotFound;

import lombok.Getter;

@ApiNotFound("SchoolTurmaNotFoundException")
@Getter
public class SchoolTurmaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2758732768145509557L;

	public SchoolTurmaNotFoundException() {
	}
}
