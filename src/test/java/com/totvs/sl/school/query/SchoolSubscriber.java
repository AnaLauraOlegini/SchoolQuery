package com.totvs.sl.school.query;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.totvs.tjf.core.common.security.SecurityPrincipal;
import com.totvs.tjf.core.message.TOTVSMessage;

@Component
public class SchoolSubscriber {

    private static final Logger LOG = LoggerFactory.getLogger(SchoolSubscriber.class);

    @Autowired
    private SchoolExchange exchange;

    public <T> void subscribe(T event) {
        Field field;
        String eventName = null;
        try {
            field = event.getClass().getField("NAME");
            eventName = (String) field.get(event);

            final String tenant = "_B56EFB27_13BB_4767_8227_77ABD3761023";
            SecurityPrincipal principal = new SecurityPrincipal("", tenant, tenant, tenant);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal,
                    null);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            new TOTVSMessage<>(eventName, event).sendTo(exchange.input());

        } catch (Exception e) {
            LOG.debug("Exchange: {}\nTopic: {}\n", exchange, eventName);
        }
    }
}
