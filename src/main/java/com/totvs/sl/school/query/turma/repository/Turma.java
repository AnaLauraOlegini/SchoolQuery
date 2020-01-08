package com.totvs.sl.school.query.turma.repository;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Turma {

	@Id
	@Column
	private String id;

	private String descricao;

	private int anoLetivo;

	private int periodoLetivo;

	private int numeroVagas;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "turma_id")
	private List<TurmaDisciplinaTurma> disciplinaId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "turma_id")
	private List<TurmaAlunoTurma> alunoId;
}
