package com.totvs.sl.school.query.aluno.amqp;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.totvs.sl.school.query.Fabrica;
import com.totvs.sl.school.query.SchoolSubscriber;
import com.totvs.sl.school.query.aluno.amqp.events.AlunoCriadoEvent;
import com.totvs.sl.school.query.aluno.repository.AlunoModel;

@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AlunoSubscriberTest {

	@Autowired
	private SchoolSubscriber schoolSubscriber;

	@Autowired
	private EntityManager em;

	@Test
	public void deveCriarUmAluno() {

		AlunoCriadoEvent event = Fabrica.novoAlunoCriadoEvent();

		schoolSubscriber.subscribe(event);

		var aluno = this.em.find(AlunoModel.class, Fabrica.alunoId);

		assertThat(aluno).isNotNull();
		assertThat(aluno.getId()).isEqualTo(Fabrica.alunoId);
		assertThat(aluno.getNome()).isEqualTo(Fabrica.alunoNome);
		assertThat(aluno.getCpf()).isEqualTo(Fabrica.alunoCpf);
		assertThat(aluno.getEmail()).isEqualTo(Fabrica.alunoEmail);
		assertThat(aluno.getFormaIngresso()).isEqualTo(Fabrica.alunoFormaIngresso);
		assertThat(aluno.getMatricula()).isEqualTo(Fabrica.alunoMatricula);
	}
}
