package com.totvs.sl.school.query.turma.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.totvs.sl.school.query.SchoolExchange;
import com.totvs.sl.school.query.turma.amqp.events.TurmaCriadaEvent;
import com.totvs.sl.school.query.turma.repository.service.TurmaService;
import com.totvs.tjf.core.message.TOTVSMessage;

@EnableBinding(SchoolExchange.class)
public class TurmaSubscriber {

	@Autowired
	private TurmaService service;

	@StreamListener(target = SchoolExchange.INPUT, condition = TurmaCriadaEvent.CONDITIONAL_EXPRESSION)
	public void turmaCriadaEvent(TOTVSMessage<TurmaCriadaEvent> event) {
		service.handle(event.getContent());
	}
}
