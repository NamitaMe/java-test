package com.abbott.merlin.service.core.app;

import java.util.Map;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class NdsDistMainService {

	@JmsListener(destination = "${nds.dist.req}")
	public void process(Message msg, @Headers Map<String, Object> headers)  {
		log.info("receive() - msg: \n" + msg);

		System.out.println("aaaaaaaaaaaaaa" + msg);
	}
}
