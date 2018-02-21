package dean.integration;


import dean.customerservice.Customer;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.stereotype.Component;

@Component
public class CustomerErrorHandler {

    @ServiceActivator
    public void handleFailure(Message<MessageHandlingException> message) {

        Customer requestedCustomer = (Customer) message.getPayload().getFailedMessage().getPayload();
        System.out.println(requestedCustomer);
    }
}
