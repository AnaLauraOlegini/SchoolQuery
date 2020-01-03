package com.totvs.sl.school.query;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SchoolExchange {

	public static final String INPUT = "school-input-events";

	@Input(SchoolExchange.INPUT)
	SubscribableChannel input();
}
