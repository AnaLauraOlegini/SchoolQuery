package com.totvs.sl.school.query.professor.amqp;

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
import com.totvs.sl.school.query.professor.amqp.events.ProfessorCriadoEvent;
import com.totvs.sl.school.query.professor.repository.ProfessorModel;

@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProfessorSubscriberTest {

	@Autowired
	private SchoolSubscriber schoolSubscriber;

	@Autowired
	private EntityManager em;

	@Test
	public void deveCriarUmProfessor() {

		ProfessorCriadoEvent event = Fabrica.novoProfessorCriadoEvent();

		schoolSubscriber.subscribe(event);

		var professor = this.em.find(ProfessorModel.class, Fabrica.professorId);

		assertThat(professor).isNotNull();
		assertThat(professor.getId()).isEqualTo(Fabrica.professorId);
		assertThat(professor.getNome()).isEqualTo(Fabrica.professorNome);
		assertThat(professor.getCpf()).isEqualTo(Fabrica.professorCpf);
		assertThat(professor.getEmail()).isEqualTo(Fabrica.professorEmail);
		assertThat(professor.getTitulacao()).isEqualTo(Fabrica.professorTitulacao);

	}

}
