package dean.integration;

import org.springframework.integration.aggregator.CorrelationStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MsgAggCorrStrat implements CorrelationStrategy {
    @Override
    public Object getCorrelationKey(Message<?> message) {
        if (message.getHeaders().containsKey("Aggregation")) {
            return message.getHeaders().get("Aggregation");
        }
        throw new IllegalStateException("messages must have 'Aggregation' header field you clown");
    }
}
