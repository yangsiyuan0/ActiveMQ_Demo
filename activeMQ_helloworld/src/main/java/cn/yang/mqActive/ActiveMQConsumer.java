package cn.yang.mqActive;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * MQ的消费者
 * @author yang
 *
 */
public class ActiveMQConsumer {

	@Test
	public void testConsumer() throws JMSException{
		//建立连接工厂【使用默认的用户名、密码、路径(tcp://host:post)】默认端口61616
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		// 获取连接
		Connection connection = connectionFactory.createConnection();
		connection.start();// 连接必须开启
		// 建立会话session【是否使用事务（如果开启，必须commit）】
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 创建消息对象【topic或者queue】
		Queue queue = session.createQueue("helloworld");
		// 创建消费者
		MessageConsumer consumer = session.createConsumer(queue);
		// 接收+处理消息
		while(true){
			TextMessage message = (TextMessage) consumer.receive();
			if(message.getText() != null){
				System.out.println(message.getText());
			}else{
				break;
			}
		}
		session.commit();
	}
}
