package cn.yang.mqActive;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * MQ的监听者
 * @author yang
 *
 */
public class ActiveMQListner {
	
	@Test
	public void testListner() throws JMSException{
		//建立连接工厂【使用默认的用户名、密码、路径(tcp://host:post)】默认端口61616
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		// 获取连接
		Connection connection = connectionFactory.createConnection();
		connection.start();
		// 建立会话session【是否使用事务，】
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		// 创建消息对象【topic或者queue】
		Queue queue = session.createQueue("helloworld");
		// 创建消费者
		MessageConsumer consumer = session.createConsumer(queue);
		// 通过消费者创建监听器
		consumer.setMessageListener(new MessageListener() {
			// 自动调用onMessage来接收并处理消息
			public void onMessage(Message message) {
				TextMessage testMessage = (TextMessage) message;
				try {
					System.out.println(testMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		while(true){} //不能让junit结束，线程死掉，监听就结束了
	}
}
