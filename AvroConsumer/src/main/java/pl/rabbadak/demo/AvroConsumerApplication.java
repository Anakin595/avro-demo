package pl.rabbadak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class AvroConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvroConsumerApplication.class, args);
	}

}
