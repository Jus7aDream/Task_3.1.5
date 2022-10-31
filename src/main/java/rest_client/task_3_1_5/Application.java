package rest_client.task_3_1_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import rest_client.task_3_1_5.models.User;
import rest_client.task_3_1_5.resources.Connection;

@SpringBootApplication
public class Application {
    @Bean
    static public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        User userJames = new User(3L, "James", "Brown", (byte) 33);
        User userThomas = new User(3L, "Thomas", "Shelby", (byte) 33);
        Connection connection = new Connection(getRestTemplate(), getHttp());
        connection.listUser();
        connection.saveUser(userJames);
        connection.editUser(userThomas);
        connection.deleteUser(3L);
    }

    @Bean
    static public HttpHeaders getHttp() {
        return new HttpHeaders();
    }
}
