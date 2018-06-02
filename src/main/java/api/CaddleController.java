package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/caddle")
public class CaddleController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Ok");

    }

    @SpringBootApplication
    public static class FarmApplication {

        public static void main(String[] args) {
            SpringApplication.run(FarmApplication.class, args);
        }
    }
}
