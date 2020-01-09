package com.totvs.sl.school.query.turma.amqp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.totvs.sl.school.query.Fabrica;
import com.totvs.sl.school.query.SchoolSubscriber;
import com.totvs.sl.school.query.turma.amqp.events.TurmaCriadaEvent;
import com.totvs.sl.school.query.turma.repository.Turma;

@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TurmaSubscriberTest {
	
	@Autowired
	private SchoolSubscriber schoolSubscriber;
	
	@Autowired
	private EntityManager em;
	
	private String turmaId = UUID.randomUUID().toString();

	@Test
	public void deveCriarUmaTurma() {
		TurmaCriadaEvent event = Fabrica.novaTurmaCriadaEvent(turmaId);

		schoolSubscriber.subscribe(event);

		var turma = this.em.find(Turma.class, turmaId);

		assertThat(turma).isNotNull();
		assertThat(turma.getId()).isEqualTo(turmaId);
		assertThat(turma.getDescricao()).isEqualTo(Fabrica.turmaDescricao1);
		assertThat(turma.getAnoLetivo()).isEqualTo(Fabrica.turmaAnoLetivo1);
		assertThat(turma.getPeriodoLetivo()).isEqualTo(Fabrica.turmaPeriodoLetivo1);
		assertThat(turma.getNumeroVagas()).isEqualTo(Fabrica.turmaNumeroVagas1);
		assertThat(turma.getDisciplinaId()).size().isEqualTo(3);
		assertThat(turma.getAlunoId()).size().isEqualTo(3);

	}	
}
