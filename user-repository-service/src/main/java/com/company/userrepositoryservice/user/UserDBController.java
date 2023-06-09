package com.company.userrepositoryservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 19:22
 * microservie-task
 */
@RestController
@RequestMapping("/api/user-db")
@RequiredArgsConstructor
public class UserDBController {

    private final UserRepository repository;

    @GetMapping("/username/{username}")
    public User findByName(@PathVariable String username) {
        return repository.findByUsername(username).orElse(null);
    }

    @PostMapping
    public Long save(@RequestBody @Valid User user) {
        return repository.save(user).getId();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable String id) {
        return repository.findById(Long.parseLong(id)).orElse(null);
    }

    @GetMapping("/getAll")
    List<User> getAll() {
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        if (repository.findById(Long.parseLong(id)).isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        repository.deleteById(Long.parseLong(id));
    }
}
