package ua.com.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SolutionFaceItApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolutionFaceItApplication.class, args);
    }
}