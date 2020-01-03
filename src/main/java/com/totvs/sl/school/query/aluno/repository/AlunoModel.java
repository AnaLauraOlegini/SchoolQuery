package com.totvs.sl.school.query.aluno.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@Table(name = "aluno", indexes = { @Index(name = "idx1_aluno_cpf", columnList = "cpf") })
public class AlunoModel {

	@Id
	@Column(name = "id")
	private String id;

	private String nome;
	private String cpf;
	private String email;
	private String formaIngresso;
	private int matricula;
}
