package com.totvs.sl.school.query.professor.repository;

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
@Table(name = "professor", indexes = { @Index(name = "idx1_id", columnList = "id") })
public class ProfessorModel {

	@Id
	@Column
	private String id;
	private String nome;
	private String cpf;
	private String email;
	private String titulacao;
}
