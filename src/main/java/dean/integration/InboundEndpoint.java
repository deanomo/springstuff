package dean.integration;

import dean.customerservice.Customer;
import dean.customerservice.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class InboundEndpoint {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Resource
    CustomerService custService;

    public Message<?> get(Message<?> msg) {
        log.info("GET method");
        List<Customer> custLst = custService.getAll();
        return MessageBuilder.withPayload(custLst).copyHeadersIfAbsent(msg.getHeaders())
                .setHeader("http_statusCode", HttpStatus.OK).build();
    }

    public Message<Customer> get_by_id(Message<String> msg) {
        log.info("GET_BY_ID method");
        int id = Integer.valueOf(msg.getPayload());
        return MessageBuilder.withPayload(custService.get(id))
                .copyHeadersIfAbsent(msg.getHeaders())
                .setHeader("httpStatus", HttpStatus.OK)
                .build();
    }

    public void post(Message<Customer[]> msg){
        log.info("POST method");
        custService.insert(msg.getPayload());
    }

    public void put(Message<Customer> msg){
        log.info("PUT method");
        custService.change(msg.getPayload());
    }

    public void delete(Message<String>msg){
        log.info("DELETE method");
        int id = Integer.valueOf(msg.getPayload());
        custService.delete(id);
    }
}
