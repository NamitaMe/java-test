package com.abbott.merlin.service.core.utils;

import java.io.ByteArrayOutputStream;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class JmsMessageHelper {

	public static byte[] getMessageText(Message msg) throws Exception {
		byte[] message = null;
		
		if (msg instanceof TextMessage) {
			TextMessage tm = (TextMessage) msg;
			String text = tm.getText();
			message = text.getBytes();

			log.info("getMessageText() - text message: {}", text);
		} 
		else if (msg instanceof BytesMessage) {
			BytesMessage m = (BytesMessage) msg;

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[2000];

			int length = m.readBytes(buf);
			while (length > 0) {
				baos.write(buf, 0, length);
				length = m.readBytes(buf);
			}
			
			message = baos.toByteArray();
			baos.close();

			log.info("getMessageText() - bytesmessage: {}", new String(message));
		}
		else {
			throw new Exception("Not a BytesMessage or TextMessage: " + msg.getClass().getName());
		}

		log.info("getMessageText() - message: {}", new String(message));
		
		return message;
    }	
}
