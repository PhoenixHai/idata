package org.idata.service.mq.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class QueueMessageListener implements MessageListener {
	private final Logger logger = LogManager.getLogger();

	public void onMessage(Message message) {
		try {
			System.out.println("QueueMessageListener接收到消息:" + ((ObjectMessage) message).getObject());
		} catch (JMSException e) {
			logger.error(e);
		}
	}

}
