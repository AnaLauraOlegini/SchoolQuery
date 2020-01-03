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

public class Fabrica {

	public static String alunoId = UUID.randomUUID().toString();
	public static String alunoNome = "Isabelly Elza Viana";
	public static String alunoCpf = "17869460923";
	public static String alunoEmail = "isabellyviana@gmail.com";
	public static String alunoFormaIngresso = "ENADE";
	public static int alunoMatricula = 100002;

	public static String professorId = UUID.randomUUID().toString();
	public static String professorNome = "Kauê Benjamin Sebastião Silva";
	public static String professorCpf = "80307744949";
	public static String professorEmail = "kauebenjaminsebastiao.silva@gmail.com";
	public static String professorTitulacao = "PHD";

	public static String disciplinaId = UUID.randomUUID().toString();
	public static String disciplinaProfessorId1 = UUID.randomUUID().toString();

	public static String disciplinaDescricao = "Português";
	public static String disciplinaSigla = "POR";
	public static int disciplinaCargaHoraria = 4;

	public static String professorDisciplinaId = UUID.randomUUID().toString();

	public static AlunoCriadoEvent novoAlunoCriadoEvent() {
		return AlunoCriadoEvent.builder()
		                       .alunoId(Fabrica.alunoId)
		                       .cpf(Fabrica.alunoCpf)
		                       .nome(Fabrica.alunoNome)
		                       .email(Fabrica.alunoEmail)
		                       .formaIngresso(Fabrica.alunoFormaIngresso)
		                       .matricula(Fabrica.alunoMatricula)
		                       .build();
	}

	public static AlunoModel novoAlunoModel() {
		return AlunoModel.builder()
		                 .id(Fabrica.alunoId)
		                 .nome(Fabrica.alunoNome)
		                 .cpf(Fabrica.alunoCpf)
		                 .email(Fabrica.alunoEmail)
		                 .formaIngresso(Fabrica.alunoFormaIngresso)
		                 .matricula(Fabrica.alunoMatricula)
		                 .build();
	}

	public static ProfessorCriadoEvent novoProfessorCriadoEvent() {
		return ProfessorCriadoEvent.builder()
		                           .professorId(Fabrica.professorId)
		                           .cpf(Fabrica.professorCpf)
		                           .nome(Fabrica.professorNome)
		                           .email(Fabrica.professorEmail)
		                           .titulacao(Fabrica.professorTitulacao)
		                           .build();
	}

	public static ProfessorModel novoProfessorModel() {
		return ProfessorModel.builder()
		                     .id(Fabrica.professorId)
		                     .nome(Fabrica.professorNome)
		                     .cpf(Fabrica.professorCpf)
		                     .email(Fabrica.professorEmail)
		                     .titulacao(Fabrica.professorTitulacao)
		                     .build();
	}

	public static DisciplinaCriadaEvent novaDisciplinaCriadaEvent(String disciplinaId) {
		return DisciplinaCriadaEvent.builder()
		                            .disciplinaId(disciplinaId)
		                            .descricao(Fabrica.disciplinaDescricao)
		                            .sigla(Fabrica.disciplinaSigla)
		                            .cargaHoraria(Fabrica.disciplinaCargaHoraria)
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

	public static Disciplina novaDisciplina(String disciplinaID) {
		return Disciplina.builder()
		                 .id(disciplinaID)
		                 .descricao(Fabrica.disciplinaDescricao)
		                 .sigla(Fabrica.disciplinaSigla)
		                 .cargaHoraria(Fabrica.disciplinaCargaHoraria)
		                 .professorId(Fabrica.disciplinaProfessorDisciplina())
		                 .build();
	}

	public static List<DisciplinaProfessorDisciplina> disciplinaProfessorDisciplina() {
		List<DisciplinaProfessorDisciplina> disciplinaProfessor = new ArrayList<>();

		disciplinaProfessor.add(DisciplinaProfessorDisciplina.of(Fabrica.disciplinaProfessorId1));

		return disciplinaProfessor;
	}

}
