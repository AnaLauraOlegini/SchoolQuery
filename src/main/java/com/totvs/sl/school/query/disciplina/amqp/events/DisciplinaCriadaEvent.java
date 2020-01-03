package com.totvs.sl.school.query.disciplina.amqp.events;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DisciplinaCriadaEvent {

	public static final String NAME = "DisciplinaCriadaEvent";

	public static final String CONDITIONAL_EXPRESSION = "headers['type']=='" + NAME + "'";

	private String disciplinaId;

	private String descricao;

	private String sigla;

	private int cargaHoraria;

	private List<String> professorId;

}
