package pl.rabbadak.demo;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.rabbadak.order.OrderCreatedEvent;

import static lombok.AccessLevel.PRIVATE;
import static pl.rabbadak.demo.OrderCreatedConst.Listeners.MESSAGE_READ_LISTENER_CONTAINER_FACTORY;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Component
class MessageListener {

    private OrderCreatedFacade orderCreatedFacade;

    @KafkaListener(topics = "orders", groupId = "group-1", containerFactory = MESSAGE_READ_LISTENER_CONTAINER_FACTORY)
    public void handleMessage(OrderCreatedEvent event) {
        log.info("[READ MESSAGE] message {}", event.toString());
        orderCreatedFacade.consume(event);
    }
}
