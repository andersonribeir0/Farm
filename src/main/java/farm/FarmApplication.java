package farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;

@SpringBootApplication
public class FarmApplication extends WebSocketServletAutoConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(FarmApplication.class, args);
    }
}
