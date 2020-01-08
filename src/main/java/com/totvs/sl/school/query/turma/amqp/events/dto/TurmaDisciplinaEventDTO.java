package com.totvs.sl.school.query.turma.amqp.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurmaDisciplinaEventDTO {

	private TurmaDisciplinaIdEventDTO disciplinaId;

	private TurmaDisciplinaEventDTO(TurmaDisciplinaIdEventDTO disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public static TurmaDisciplinaEventDTO of(TurmaDisciplinaIdEventDTO disciplinaId) {
		return new TurmaDisciplinaEventDTO(disciplinaId);
	}
}
