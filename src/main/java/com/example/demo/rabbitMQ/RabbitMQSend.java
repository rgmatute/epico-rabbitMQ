package com.example.demo.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSend {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;

	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;

	public void send(String message) {
		try {
			this.amqpTemplate.convertAndSend(this.exchange, this.routingKey, message);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
