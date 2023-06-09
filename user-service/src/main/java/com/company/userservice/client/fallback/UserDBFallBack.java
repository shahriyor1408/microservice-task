package com.company.userservice.client.fallback;

import com.company.userservice.client.UserDBClient;
import com.company.userservice.dto.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 06/06/23 12:00
 * microservie-task
 */

@Component
public class UserDBFallBack implements UserDBClient {

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public Long save(User user) {
        return null;
    }

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {
        throw new RuntimeException("User is not deleted!");
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>();
    }
}
