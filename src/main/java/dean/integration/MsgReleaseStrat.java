package dean.integration;

import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;
import org.springframework.stereotype.Component;

@Component
public class MsgReleaseStrat implements ReleaseStrategy {
    @Override
    public boolean canRelease(MessageGroup group) {
        return group.getMessages().stream()
                .map(m -> m.getHeaders())
                .anyMatch(v -> (boolean) v.get("isLast"));
    }
}
