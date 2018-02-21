package dean.integration;

import org.springframework.stereotype.Component;

@Component
public class ResponseGenerator {

    public String getResponseMessage(String s) {
        return String.format("hello %s from the response generator", s);
    }
}
