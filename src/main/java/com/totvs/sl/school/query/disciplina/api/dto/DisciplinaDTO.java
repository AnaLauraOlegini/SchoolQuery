package com.totvs.sl.school.query.disciplina.api.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DisciplinaDTO {

	private String id;

	private String descricao;

	private String sigla;

	private int cargaHoraria;

	private List<String> professorId;

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String id;

		private String descricao;

		private String sigla;

		private int cargaHoraria;

		private List<String> professorId;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public Builder sigla(String sigla) {
			this.sigla = sigla;
			return this;
		}

		public Builder cargaHoraria(int cargaHoraria) {
			this.cargaHoraria = cargaHoraria;
			return this;
		}

		public Builder professorId(List<String> professorId) {
			this.professorId = professorId;
			return this;
		}

		public DisciplinaDTO build() {
			return new DisciplinaDTO(this.id, this.descricao, this.sigla, this.cargaHoraria, this.professorId);
		}
	}

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@NoArgsConstructor
	@Getter
	public static class DisciplinaProfessorDTO {

		private String disciplinaProfessorId;

		public static DisciplinaProfessorBuilder builder() {
			return new DisciplinaProfessorBuilder();
		}

		public static class DisciplinaProfessorBuilder {

			private String professorId;

			public DisciplinaProfessorBuilder disciplinaProfessorId(String professorId) {
				this.professorId = professorId;
				return this;
			}

			public DisciplinaProfessorDTO build() {
				return new DisciplinaProfessorDTO(this.professorId);
			}

		}

	}

}