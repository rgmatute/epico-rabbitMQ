package com.example.demo.api;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rabbitMQ.RabbitMQSend;

@RestController
@RequestMapping("/api/rabbitMQ")
public class RabbirQMController {
	
	@Autowired
	RabbitMQSend rabbitMQSend;
	
	
	@PostMapping("/send-message")
	public Object sendMessage(@RequestParam String message) {
		
		rabbitMQSend.send("Hola mundo, t solicitud fue completada..");
		
		return "Por favor espera a tu solicitud , se complete...";
	}

}
