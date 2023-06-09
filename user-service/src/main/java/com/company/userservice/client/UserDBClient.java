package com.company.userservice.client;

import com.company.userservice.client.fallback.UserDBFallBack;
import com.company.userservice.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 06/06/23 11:40
 * microservie-task
 */

@FeignClient(value = "USER-DB-SERVICE", path = "/api/user-db",
        fallbackFactory = UserDBFallBack.class)
public interface UserDBClient {

    @GetMapping("/username/{username}")
    User findByName(@PathVariable String username);

    @PostMapping
    Long save(User user);

    @GetMapping("/{id}")
    User get(@PathVariable String id);

    @DeleteMapping("{id}")
    void delete(@PathVariable String id);

    @GetMapping("/getAll")
    List<User> getAll();
}
