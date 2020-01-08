package com.totvs.sl.school.query.turma.amqp.events.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurmaDisciplinaIdEventDTO {

	private String id;

	private TurmaDisciplinaIdEventDTO(String id) {
		this.id = id;
	}

	public static TurmaDisciplinaIdEventDTO of(String id) {
		return new TurmaDisciplinaIdEventDTO(id);
	}

}
