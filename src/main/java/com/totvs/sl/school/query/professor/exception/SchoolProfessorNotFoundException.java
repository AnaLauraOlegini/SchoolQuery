package com.totvs.sl.school.query.professor.exception;

import com.totvs.tjf.api.context.stereotype.ApiErrorParameter;
import com.totvs.tjf.api.context.stereotype.error.ApiNotFound;

import lombok.Getter;

@ApiNotFound("SchoolProfessorNotFoundException")
@Getter
public class SchoolProfessorNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 2100396918453973429L;
    
    @ApiErrorParameter
    private final String professor;
    
    public SchoolProfessorNotFoundException(String professor) {
        this.professor = professor;
    }
}
