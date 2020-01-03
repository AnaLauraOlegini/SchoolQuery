package com.totvs.sl.school.query.professor.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.totvs.sl.school.query.SchoolExchange;
import com.totvs.sl.school.query.professor.amqp.events.ProfessorCriadoEvent;
import com.totvs.sl.school.query.professor.repository.service.ProfessorService;
import com.totvs.tjf.core.message.TOTVSMessage;

@EnableBinding(SchoolExchange.class)
public class ProfessorSubscriber {

	@Autowired
	private ProfessorService service;

	@StreamListener(target = SchoolExchange.INPUT, condition = ProfessorCriadoEvent.CONDITIONAL_EXPRESSION)
	public void professorCriadoEvent(TOTVSMessage<ProfessorCriadoEvent> event) {
		service.handle(event.getContent());
	}

}
