package com.totvs.sl.school.query.turma.amqp.events;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TurmaCriadaEvent {

	public static final String NAME = "TurmaCriadaEvent";

	public static final String CONDITIONAL_EXPRESSION = "headers['type']=='" + NAME + "'";

	@NonNull
	private String turmaId;

	@NonNull
	private String descricao;

	private int anoLetivo;

	private int periodoLetivo;

	private int numeroVagas;

	private List<String> disciplinaId;

	private List<String> alunoId;
}
