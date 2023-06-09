package com.company.webapiservice.webUI.client;

import com.company.webapiservice.webUI.client.fallback.UserServiceFallBack;
import com.company.webapiservice.webUI.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 06/06/23 11:40
 * microservie-task
 */

@FeignClient(value = "USER-SERVICE", path = "/api/user-service",
        fallbackFactory = UserServiceFallBack.class)
public interface UserServiceClient {

    @GetMapping("/username/{username}")
    UserDto findByUsername(@PathVariable String username);

    @PostMapping("/save")
    Long save(UserDto build);

    @GetMapping("/{id}")
    UserDto get(@PathVariable String id);

    @GetMapping("/check/{id}")
    boolean checkById(@PathVariable String id);

    @DeleteMapping("/{id}")
    Long delete(@PathVariable String id);

    @GetMapping("/getAll")
    List<UserDto> getAll();

    @PutMapping
    Long update(@RequestBody UserDto build);
}
