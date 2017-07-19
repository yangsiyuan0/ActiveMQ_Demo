package cn.yang.activeMQ.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yang.activeMQ.producer.queue.QueueSender;
import cn.yang.activeMQ.producer.topic.TopicSender;

/**
 * 测试
 * @author yang
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-mq.xml")
public class ProducerTest {
	@Autowired
	private QueueSender queueSender;
	
	@Autowired
	private TopicSender topicSender;
	
	@Test
	public void testSend(){
		queueSender.send("spring_queue", "hello,this is queue message");
		topicSender.send("spring_topic", "hello,this is topic message");
	}
}
