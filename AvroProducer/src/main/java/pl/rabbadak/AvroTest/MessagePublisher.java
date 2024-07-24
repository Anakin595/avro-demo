package pl.rabbadak.AvroTest;

import org.apache.avro.specific.SpecificRecord;

public interface MessagePublisher<T> {

    void publish(final String topicName, final SpecificRecord message, final String key);
}
