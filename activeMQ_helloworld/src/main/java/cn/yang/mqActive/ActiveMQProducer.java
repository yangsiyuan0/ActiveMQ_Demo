package cn.yang.mqActive;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * MQ的生产者
 * @author yang
 *
 */

public class ActiveMQProducer {
	
	@Test
	public void testProducer() throws JMSException{
		
		//建立连接工厂【使用默认的用户名、密码、路径(tcp://host:post)】默认端口61616
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		// 获取连接
		Connection connection = connectionFactory.createConnection();
		connection.start();
		// 建立会话session【是否使用事务，】
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		// 创建消息对象【topic或者queue】
		Queue queue = session.createQueue("helloworld");
		// 创建消费者/生产者
		MessageProducer producer = session.createProducer(queue);
		// 发送消息【文本】
		for (int j = 1; j < 11; j++) {
			producer.send(session.createTextMessage("hello,activeMQ"+j));
		}
		// 提交操作
		session.commit();
		
	}
}
