package com.totvs.sl.school.query.aluno.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.totvs.sl.school.query.SchoolExchange;
import com.totvs.sl.school.query.aluno.amqp.events.AlunoCriadoEvent;
import com.totvs.sl.school.query.aluno.repository.service.AlunoService;
import com.totvs.tjf.core.message.TOTVSMessage;

@EnableBinding(SchoolExchange.class)
public class AlunoSubscriber {

	@Autowired
	private AlunoService service;
	
	@StreamListener(target = SchoolExchange.INPUT, condition = AlunoCriadoEvent.CONDITIONAL_EXPRESSION)
	public void alunoCriadoEvent(TOTVSMessage<AlunoCriadoEvent> event) {
		service.handle(event.getContent());
	}
}
