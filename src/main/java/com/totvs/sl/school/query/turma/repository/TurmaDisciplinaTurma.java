package com.totvs.sl.school.query.turma.repository;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(indexes = { @Index(name = "idx1_turma_disciplina_disciplina_id", columnList = "disciplinaId") })
public class TurmaDisciplinaTurma {

	@Id
	@GeneratedValue
	private UUID id;

	private String disciplinaId;

	public TurmaDisciplinaTurma(String disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public static TurmaDisciplinaTurma of(String disciplinaId) {
		return new TurmaDisciplinaTurma(disciplinaId);
	}
}
