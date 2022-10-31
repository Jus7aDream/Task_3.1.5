package rest_client.task_3_1_5.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @ In the name of Allah, most gracious and most merciful! 31.10.2022
 */
@RestController
@RequiredArgsConstructor
public class ApiController {
    private final RestTemplate restTemplate;
    private final String URL = "http://94.198.50.185:7081/api/users";

    @GetMapping("users")
    public List<Object> getUsers() {
        Object[] users = restTemplate.getForObject(URL, Object[].class);
        return Arrays.asList(users);
    }
}
