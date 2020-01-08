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
@Table(indexes = { @Index(name = "idx1_turma_aluno_aluno_id", columnList = "alunoId") })
public class TurmaAlunoTurma {

	@Id
	@GeneratedValue
	private UUID id;

	private String alunoId;

	public TurmaAlunoTurma(String alunoId) {
		this.alunoId = alunoId;
	}

	public static TurmaAlunoTurma of(String alunoId) {
		return new TurmaAlunoTurma(alunoId);
	}
}
