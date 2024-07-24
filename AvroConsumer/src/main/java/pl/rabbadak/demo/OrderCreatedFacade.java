package pl.rabbadak.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.rabbadak.order.OrderCreatedEvent;

@Slf4j
@Component
public class OrderCreatedFacade {

    public void consume(OrderCreatedEvent event) {
        log.info("Consuming {}", event);
    }
}
