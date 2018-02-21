package dean.integration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageSplitter extends AbstractMessageSplitter {


    @Override
    protected Object splitMessage(Message<?> message) {
        return message;
    }
}
