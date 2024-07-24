package pl.rabbadak.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Configuration
@Getter
@Setter
class KafkaProperties {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    String bootstrapServers;

    @Value("${spring.kafka.consumer.schema.registry.url}")
    String schemaRegistryUrl;
}