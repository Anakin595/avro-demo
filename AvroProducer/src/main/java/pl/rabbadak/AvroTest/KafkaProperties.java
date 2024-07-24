package pl.rabbadak.AvroTest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Configuration
@Getter
@Setter
public class KafkaProperties {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    String bootstrapServers;

    @Value("${spring.kafka.topic.orders}")
    String topicName;

    @Value("${spring.kafka.producer.schema.registry.url}")
    String schemaRegistryUrl;
}