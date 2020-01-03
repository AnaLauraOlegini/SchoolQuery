package com.totvs.sl.school.query.disciplina.amqp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

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
import com.totvs.sl.school.query.disciplina.amqp.events.DisciplinaCriadaEvent;
import com.totvs.sl.school.query.disciplina.repository.Disciplina;

@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DisciplinaSubscriberTest {

	@Autowired
	private SchoolSubscriber schoolSubscriber;

	@Autowired
	private EntityManager em;

//        @Autowired
//        private DisciplinaRepository disciplinaRepository;

	private String disciplinaId = UUID.randomUUID().toString();

	@Test
	public void deveCriarUmaDisciplina() {
		DisciplinaCriadaEvent event = Fabrica.novaDisciplinaCriadaEvent(disciplinaId);

		schoolSubscriber.subscribe(event);

		var disciplina = this.em.find(Disciplina.class, disciplinaId);

		assertThat(disciplina).isNotNull();
		assertThat(disciplina.getId()).isEqualTo(disciplinaId);
		assertThat(disciplina.getDescricao()).isEqualTo(Fabrica.disciplinaDescricao);
		assertThat(disciplina.getSigla()).isEqualTo(Fabrica.disciplinaSigla);
		assertThat(disciplina.getCargaHoraria()).isEqualTo(Fabrica.disciplinaCargaHoraria);
		assertThat(disciplina.getProfessorId()).size().isEqualTo(1);

	}

}
