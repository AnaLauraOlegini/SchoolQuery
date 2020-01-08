package com.totvs.sl.school.query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.totvs.sl.school.query.aluno.amqp.events.AlunoCriadoEvent;
import com.totvs.sl.school.query.aluno.repository.AlunoModel;
import com.totvs.sl.school.query.disciplina.amqp.events.DisciplinaCriadaEvent;
import com.totvs.sl.school.query.disciplina.repository.Disciplina;
import com.totvs.sl.school.query.disciplina.repository.DisciplinaProfessorDisciplina;
import com.totvs.sl.school.query.professor.amqp.events.ProfessorCriadoEvent;
import com.totvs.sl.school.query.professor.repository.ProfessorModel;
import com.totvs.sl.school.query.turma.amqp.events.TurmaCriadaEvent;
import com.totvs.sl.school.query.turma.repository.Turma;
import com.totvs.sl.school.query.turma.repository.TurmaAlunoTurma;
import com.totvs.sl.school.query.turma.repository.TurmaDisciplinaTurma;

public class Fabrica {

	public static String alunoId1 = UUID.randomUUID().toString();
	public static String alunoNome1 = "Aluno 1";
	public static String alunoCpf1 = "17869460923";
	public static String alunoEmail1 = "aluno1@gmail.com";
	public static String alunoFormaIngresso1 = "ENADE";
	public static int alunoMatricula1 = 100001;

	public static String alunoId2 = UUID.randomUUID().toString();
	public static String alunoNome2 = "Aluno 2";
	public static String alunoCpf2 = "47871560042";
	public static String alunoEmail2 = "aluno2@gmail.com";
	public static String alunoFormaIngresso2 = "ENADE";
	public static int alunoMatricula2 = 100002;

	public static String professorId1 = UUID.randomUUID().toString();
	public static String professorNome1 = "Professor 1";
	public static String professorCpf1 = "80307744949";
	public static String professorEmail1 = "professor1@gmail.com";
	public static String professorTitulacao1 = "PHD";

	public static String professorId2 = UUID.randomUUID().toString();
	public static String professorNome2 = "Professor 2";
	public static String professorCpf2 = "64246816043";
	public static String professorEmail2 = "professor2@gmail.com";
	public static String professorTitulacao2 = "PHD";

	public static String disciplinaId1 = UUID.randomUUID().toString();
	public static String disciplinaProfessorId1 = UUID.randomUUID().toString();

	public static String disciplinaDescricao1 = "Português";
	public static String disciplinaSigla1 = "POR";
	public static int disciplinaCargaHoraria1 = 4;

	public static String disciplinaDescricao2 = "História";
	public static String disciplinaSigla2 = "HIS";
	public static int disciplinaCargaHoraria2 = 3;

	public static String turmaDisciplinaId1 = UUID.randomUUID().toString();
	public static String turmaAlunoId1 = UUID.randomUUID().toString();

	public static String turmaDisciplinaId2 = UUID.randomUUID().toString();
	public static String turmaAlunoId2 = UUID.randomUUID().toString();
	
	public static String turmaDescricao1 = "Turma do Enade";
	public static int turmaAnoLetivo1 = 2020;
	public static int turmaPeriodoLetivo1 = 12020;
	public static int turmaNumeroVagas1 = 4;

	public static AlunoCriadoEvent novoAlunoCriadoEvent() {
		return AlunoCriadoEvent.builder()
		                       .alunoId(Fabrica.alunoId1)
		                       .cpf(Fabrica.alunoCpf1)
		                       .nome(Fabrica.alunoNome1)
		                       .email(Fabrica.alunoEmail1)
		                       .formaIngresso(Fabrica.alunoFormaIngresso1)
		                       .matricula(Fabrica.alunoMatricula1)
		                       .build();
	}

	public static AlunoModel novoAlunoModel() {
		return AlunoModel.builder()
		                 .id(Fabrica.alunoId2)
		                 .nome(Fabrica.alunoNome2)
		                 .cpf(Fabrica.alunoCpf2)
		                 .email(Fabrica.alunoEmail2)
		                 .formaIngresso(Fabrica.alunoFormaIngresso2)
		                 .matricula(Fabrica.alunoMatricula2)
		                 .build();
	}

	public static ProfessorCriadoEvent novoProfessorCriadoEvent() {
		return ProfessorCriadoEvent.builder()
		                           .professorId(Fabrica.professorId1)
		                           .cpf(Fabrica.professorCpf1)
		                           .nome(Fabrica.professorNome1)
		                           .email(Fabrica.professorEmail1)
		                           .titulacao(Fabrica.professorTitulacao1)
		                           .build();
	}

	public static ProfessorModel novoProfessorModel() {
		return ProfessorModel.builder()
		                     .id(Fabrica.professorId2)
		                     .nome(Fabrica.professorNome2)
		                     .cpf(Fabrica.professorCpf2)
		                     .email(Fabrica.professorEmail2)
		                     .titulacao(Fabrica.professorTitulacao2)
		                     .build();
	}

	public static DisciplinaCriadaEvent novaDisciplinaCriadaEvent(String disciplinaId) {
		return DisciplinaCriadaEvent.builder()
		                            .disciplinaId(disciplinaId)
		                            .descricao(Fabrica.disciplinaDescricao1)
		                            .sigla(Fabrica.disciplinaSigla1)
		                            .cargaHoraria(Fabrica.disciplinaCargaHoraria1)
		                            .professorId(Fabrica.disciplinaProfessoresDto())
		                            .build();
	}

	public static List<String> disciplinaProfessoresDto() {

		List<String> ptCtrlDisciplinaDto = new ArrayList<>();

		ptCtrlDisciplinaDto.add(UUID.randomUUID().toString());
		ptCtrlDisciplinaDto.add(UUID.randomUUID().toString());
		ptCtrlDisciplinaDto.add(UUID.randomUUID().toString());

		return ptCtrlDisciplinaDto;
	}

	public static Disciplina novaDisciplina(String disciplinaId) {
		return Disciplina.builder()
		                 .id(disciplinaId)
		                 .descricao(Fabrica.disciplinaDescricao1)
		                 .sigla(Fabrica.disciplinaSigla1)
		                 .cargaHoraria(Fabrica.disciplinaCargaHoraria1)
		                 .professorId(Fabrica.disciplinaProfessorDisciplina())
		                 .build();
	}

	public static List<DisciplinaProfessorDisciplina> disciplinaProfessorDisciplina() {
		List<DisciplinaProfessorDisciplina> disciplinaProfessor = new ArrayList<>();

		disciplinaProfessor.add(DisciplinaProfessorDisciplina.of(Fabrica.disciplinaProfessorId1));

		return disciplinaProfessor;
	}

	public static ProfessorModel novoProfessorDisciplina(String disciplinaProfessorId1) {
		return ProfessorModel.builder()
		                     .id(disciplinaProfessorId1)
		                     .nome(Fabrica.professorNome1)
		                     .cpf(Fabrica.professorCpf1)
		                     .email(Fabrica.professorEmail1)
		                     .titulacao(Fabrica.professorTitulacao1)
		                     .build();
	}
	
	public static TurmaCriadaEvent novaTurmaCriadaEvent(String turmaId) {
		return TurmaCriadaEvent.builder()
		                       .turmaId(turmaId)
		                       .descricao(Fabrica.turmaDescricao1)
		                       .anoLetivo(Fabrica.turmaAnoLetivo1)
		                       .periodoLetivo(Fabrica.turmaPeriodoLetivo1)
		                       .numeroVagas(Fabrica.turmaNumeroVagas1)
		                       .disciplinaId(Fabrica.turmaDisciplinaAlunosDto())
		                       .alunoId(Fabrica.turmaDisciplinaAlunosDto())
		                       .build();
	}

	public static List<String> turmaDisciplinaAlunosDto() {
		List<String> ptCtrlListaDto = new ArrayList<>();

		ptCtrlListaDto.add(UUID.randomUUID().toString());
		ptCtrlListaDto.add(UUID.randomUUID().toString());
		ptCtrlListaDto.add(UUID.randomUUID().toString());

		return ptCtrlListaDto;
	}

	public static Turma novaTurma(String turmaId) {
		return Turma.builder()
		                 .id(turmaId)
		                 .descricao(Fabrica.turmaDescricao1)
		                 .anoLetivo(Fabrica.turmaAnoLetivo1)
		                 .periodoLetivo(Fabrica.turmaPeriodoLetivo1)
		                 .numeroVagas(Fabrica.turmaNumeroVagas1)
		                 .disciplinaId(Fabrica.turmaDisciplinaTurma())
		                 .alunoId(Fabrica.turmaAlunoTurma())
		                 .build();
	}

	public static List<TurmaDisciplinaTurma> turmaDisciplinaTurma() {
		List<TurmaDisciplinaTurma> turmaDisciplina = new ArrayList<>();

		turmaDisciplina.add(TurmaDisciplinaTurma.of(Fabrica.turmaDisciplinaId1));
		turmaDisciplina.add(TurmaDisciplinaTurma.of(Fabrica.turmaDisciplinaId2));

		return turmaDisciplina;
	}

	public static List<TurmaAlunoTurma> turmaAlunoTurma() {
		List<TurmaAlunoTurma> turmaAluno = new ArrayList<>();

		turmaAluno.add(TurmaAlunoTurma.of(Fabrica.turmaAlunoId1));
		turmaAluno.add(TurmaAlunoTurma.of(Fabrica.turmaAlunoId2));

		return turmaAluno;
	}
}
