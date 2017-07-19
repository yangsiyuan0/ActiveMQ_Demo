package cn.yang.activeMQ.consumer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

/**
 * 利用监听器的模式来完成消费者
 * @author yang
 *
 */
@Service
public class QueueConsumer1 implements MessageListener{

	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("QueueConsumer1:\t" + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
