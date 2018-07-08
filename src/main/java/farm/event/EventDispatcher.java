package farm.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventDispatcher {

    private RabbitTemplate rabbitTemplate;
    private String milkProductionExchange;
    private String milkProductionCreatedKey;

    @Autowired
    EventDispatcher(
            final RabbitTemplate rabbitTemplate,
            @Value("${milk-production.exchange}") final String milkProductionExchange,
            @Value("${milk-production.created.key}") final String milkProductionCreatedKey

    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.milkProductionExchange = milkProductionExchange;
        this.milkProductionCreatedKey = milkProductionCreatedKey;
    }

    public void send(final MilkProductionCreatedEvent milkProductionCreatedEvent) {
        rabbitTemplate.convertAndSend(
                milkProductionExchange,
                milkProductionCreatedKey,
                milkProductionCreatedEvent
        );
    }
}
