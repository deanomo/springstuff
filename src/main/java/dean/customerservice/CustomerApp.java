package dean.customerservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:http-post-adapter.xml",
        "classpath:http-inbound-gate.xml",
        "classpath:http-delete-adapter.xml",
        "classpath:http-put-adapter.xml",
        "classpath:http-get-by-id-adapter.xml"})
public class CustomerApp {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }
}
