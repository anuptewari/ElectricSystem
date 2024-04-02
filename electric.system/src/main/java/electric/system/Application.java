package electric.system;

import electric.system.model.User;
import electric.system.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * In this project, when we will run the app its initially create database with tables,
     * so its load 10 demo user
     */
    @Bean
    public CommandLineRunner initializeDemoData(UserService userService) {
        return args -> {
            // Creating 10 demo users
            for (int i = 1; i <= 10; i++) {
                User user = new User("Doe" + i, "John" + i, "john" + i + "@example.com", "password" + i);
                userService.createUser(user);
            }
        };
    }

}
