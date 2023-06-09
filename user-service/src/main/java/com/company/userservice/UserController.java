package com.company.userservice;

import com.company.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 19:46
 * microservie-task
 */

@RestController
@RequestMapping("/api/user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @GetMapping("/username/{username}")
    public UserDto findByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }

    @PostMapping("/save")
    public Long save(@Valid @RequestBody UserDto build) {
        return service.save(build);
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable String id) {
        return service.get(id);
    }

    @GetMapping("/check/{id}")
    public boolean checkById(@PathVariable String id) {
        return service.checkById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @PutMapping
    public Long update(@RequestBody UserDto dto) {
        return service.update(dto);
    }
}
