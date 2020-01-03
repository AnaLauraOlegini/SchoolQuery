package com.totvs.sl.school.query.disciplina.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.totvs.sl.school.query.SchoolExchange;
import com.totvs.sl.school.query.disciplina.amqp.events.DisciplinaCriadaEvent;
import com.totvs.sl.school.query.disciplina.repository.service.DisciplinaService;
import com.totvs.tjf.core.message.TOTVSMessage;

@EnableBinding(SchoolExchange.class)
public class DisciplinaSubscriber {

	@Autowired
	private DisciplinaService service;

	@StreamListener(target = SchoolExchange.INPUT, condition = DisciplinaCriadaEvent.CONDITIONAL_EXPRESSION)
	public void disciplinaCriadaEvent(TOTVSMessage<DisciplinaCriadaEvent> event) {
		service.handle(event.getContent());
	}
}