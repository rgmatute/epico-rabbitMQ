package com.example.demo.rabbitMQ;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {
	
	
	@RabbitListener(queues = { "epico-queue" })
	public void recievedMessage(String message) {
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("He recibido un mensaje de RabbitMQ: " + message);
		
	}

}
