package ca.vanier.fobapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"ca.vanier.systemlib.entity"})
public class FobApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FobApiApplication.class, args);
    }

}
