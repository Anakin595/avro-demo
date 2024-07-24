package pl.rabbadak.AvroTest;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.record.SimpleRecord;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class KafkaSyncMessagePublisher implements MessagePublisher<SpecificRecord> {

    KafkaTemplate<String, SpecificRecord> kafkaTemplate;

    @Override
    public void publish(final String topicName, final SpecificRecord message, final String key) {
        final var producerRecord = new ProducerRecord<>(topicName, key, message);
        try {
            final var sendResult = kafkaTemplate.send(producerRecord);
            kafkaTemplate.flush();
            sendResult.get();
            log.info("Send message");
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Sending interrupted", e);
        } catch (final KafkaException | ExecutionException e) {
            log.error("There was error while synchronous send event to Kafka cluster", e);
        }
    }

    @Scheduled(fixedDelay = 1000)
    private void publishMessage() {
        log.info("Publishing message...");
        SpecificRecord record = new OrderCreatedEvent("1");
        publish("orders", record, "order_1");
        log.info("Message Published!");
    }
}
