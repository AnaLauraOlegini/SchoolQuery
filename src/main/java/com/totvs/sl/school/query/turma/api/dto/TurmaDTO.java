package com.totvs.sl.school.query.turma.api.dto;

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
public class TurmaDTO {

	private String id;

	private String descricao;

	private int anoLetivo;

	private int periodoLetivo;

	private int numeroVagas;

	private List<String> disciplinaId;

	private List<String> alunoId;

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String id;

		private String descricao;

		private int anoLetivo;

		private int periodoLetivo;

		private int numeroVagas;

		private List<String> disciplinaId;

		private List<String> alunoId;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public Builder anoLetivo(int anoLetivo) {
			this.anoLetivo = anoLetivo;
			return this;
		}

		public Builder periodoLetivo(int periodoLetivo) {
			this.periodoLetivo = periodoLetivo;
			return this;
		}

		public Builder numeroVagas(int numeroVagas) {
			this.numeroVagas = numeroVagas;
			return this;
		}

		public Builder disciplinaId(List<String> disciplinaId) {
			this.disciplinaId = disciplinaId;
			return this;
		}

		public Builder alunoId(List<String> alunoId) {
			this.alunoId = alunoId;
			return this;
		}

		public TurmaDTO build() {
			return new TurmaDTO(this.id,
			                    this.descricao,
			                    this.anoLetivo,
			                    this.periodoLetivo,
			                    this.numeroVagas,
			                    this.disciplinaId,
			                    this.alunoId);
		}
	}

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@NoArgsConstructor
	@Getter
	public static class TurmaDisciplinaDTO {

		private String turmaDisciplinaId;

		public static TurmaDisciplinaBuilder builder() {
			return new TurmaDisciplinaBuilder();
		}

		public static class TurmaDisciplinaBuilder {

			private String disciplinaId;

			public TurmaDisciplinaBuilder turmaDisciplinaId(String disciplinaId) {
				this.disciplinaId = disciplinaId;
				return this;
			}

			public TurmaDisciplinaDTO build() {
				return new TurmaDisciplinaDTO(this.disciplinaId);
			}

		}
	}

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@NoArgsConstructor
	@Getter
	public static class TurmaAlunoDTO {

		private String turmaAlunoId;

		public static TurmaAlunoBuilder builder() {
			return new TurmaAlunoBuilder();
		}

		public static class TurmaAlunoBuilder {

			private String alunoId;

			public TurmaAlunoBuilder turmaAlunoId(String alunoId) {
				this.alunoId = alunoId;
				return this;
			}

			public TurmaAlunoDTO build() {
				return new TurmaAlunoDTO(this.alunoId);
			}

		}
	}
}
