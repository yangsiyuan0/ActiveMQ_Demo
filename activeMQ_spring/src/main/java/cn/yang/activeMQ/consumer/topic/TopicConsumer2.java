package cn.yang.activeMQ.consumer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

@Service
public class TopicConsumer2  implements MessageListener{

	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("TopicConsumer2:\t" + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
