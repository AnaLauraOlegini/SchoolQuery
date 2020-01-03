package com.totvs.sl.school.query.disciplina.repository;

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
@Table(indexes = { @Index(name = "idx1_disciplina_professor_professor_id", columnList = "professorId") })
public class DisciplinaProfessorDisciplina {

	@Id
	@GeneratedValue
	private UUID id;

	private String professorId;

	public DisciplinaProfessorDisciplina(String professorId) {
		this.professorId = professorId;
	}

	public static DisciplinaProfessorDisciplina of(String professorId) {
		return new DisciplinaProfessorDisciplina(professorId);
	}

}
