package com.totvs.sl.school.query.disciplina.amqp.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DisciplinaProfessoresIdEventDTO {

	private String id;

	private DisciplinaProfessoresIdEventDTO(String id) {
		this.id = id;
	}

	public static DisciplinaProfessoresIdEventDTO of(String id) {
		return new DisciplinaProfessoresIdEventDTO(id);
	}
}
