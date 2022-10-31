package rest_client.task_3_1_5.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rest_client.task_3_1_5.models.User;

/**
 * @ In the name of Allah, most gracious and most merciful! 31.10.2022
 */
@Component
@RequiredArgsConstructor
public class Connection {

    private final RestTemplate restTemplate;
    private final HttpHeaders requestHeaders ;
    private String cookie = null;
    private final String URL = "http://94.198.50.185:7081/api/users";


    public void listUser() {
        ResponseEntity<String> response = restTemplate.getForEntity(URL,String.class);
        HttpHeaders headers = response.getHeaders();
        System.out.println("response list " + response);
        cookie = headers.getFirst("Set-Cookie");
        System.out.println("Cookie " + cookie);
    }

    public void saveUser (User user) {
        requestHeaders.add("cookie",cookie);
        HttpEntity<User> requestBody = new HttpEntity<>(user,requestHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(URL,requestBody,String.class);
        System.out.println("response POST" + response);
    }

    public void editUser(User user) {
        HttpEntity<User> requestBody = new HttpEntity<>(user,requestHeaders);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.PUT,requestBody,String.class);
        System.out.println("response PUT " + response);
    }

    public void deleteUser(Long id) {
        HttpEntity<User> requestBody = new HttpEntity<>(requestHeaders);
        ResponseEntity<String> response = restTemplate.exchange(URL + "/" + id,HttpMethod.DELETE,requestBody,String.class);
        System.out.println("response DELETE " + response);
    }
}
