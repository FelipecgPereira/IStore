package io.github.fps.istore.orders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class OrdersApplication {

//    @Bean
//    public CommandLineRunner commandLineRunner(KafkaTemplate<String,String>template){
//      return args ->   template.send("istore.orders-paid", "data","{json}");
//    }

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

}
