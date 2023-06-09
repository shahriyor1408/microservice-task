package com.company.webapiservice.webUI.client.fallback;

import com.company.webapiservice.webUI.client.UserServiceClient;
import com.company.webapiservice.webUI.dtos.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 06/06/23 11:56
 * microservie-task
 */
@Component
public class UserServiceFallBack implements UserServiceClient {

    @Override
    public UserDto findByUsername(String username) {
        return null;
    }

    @Override
    public Long save(UserDto build) {
        return null;
    }

    @Override
    public UserDto get(String id) {
        return null;
    }

    @Override
    public boolean checkById(String id) {
        throw new RuntimeException("User not found!");
    }

    @Override
    public Long delete(String id) {
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public Long update(UserDto build) {
        return -1L;
    }
}
