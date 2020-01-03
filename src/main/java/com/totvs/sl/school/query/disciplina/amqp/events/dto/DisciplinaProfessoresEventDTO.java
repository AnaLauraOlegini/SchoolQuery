package com.totvs.sl.school.query.disciplina.amqp.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplinaProfessoresEventDTO {

	private DisciplinaProfessoresIdEventDTO professorId;

	private DisciplinaProfessoresEventDTO(DisciplinaProfessoresIdEventDTO professorId) {
		this.professorId = professorId;
	}

	public static DisciplinaProfessoresEventDTO of(DisciplinaProfessoresIdEventDTO professorId) {
		return new DisciplinaProfessoresEventDTO(professorId);
	}
}
