package org.fork;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@SpringBootApplication()
public class ForkAndKnifeRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForkAndKnifeRunApplication.class, args);
    }

}
