package com.company.userservice;

import com.company.userservice.client.UserDBClient;
import com.company.userservice.dto.User;
import com.company.userservice.dto.UserDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 19:47
 * microservie-task
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDBClient client;

    public UserDto findByUsername(String username) {
        User user = client.findByName(username);
        if (Objects.isNull(user)) {
//            throw new RuntimeException("User not found!");
            return null;
        }
        return toUserDto(user);
    }

    public Long save(UserDto build) {
        User user = User.builder()
                .username(build.getUsername())
                .password(build.getPassword())
                .age(build.getAge())
                .firstname(build.getFirstName())
                .lastname(build.getLastName())
                .build();
        return client.save(user);
    }

    public UserDto get(@NonNull String id) {
        if (!check(id)) {
//            throw new RuntimeException("User not found!");
            return null;
        }
        return toUserDto(client.get(id));
    }

    public boolean checkById(@NonNull String id) {
        return check(id);
    }

    public Long delete(@NonNull String id) {
        if (!check(id)) {
//            throw new RuntimeException("User not found!");
            return -1L;
        }
        client.delete(id);
        return Long.parseLong(id);
    }

    private boolean check(String id) {
        User user = client.get(id);
        return !Objects.isNull(user);
    }

    public List<UserDto> getAll() {
        List<User> users = client.getAll();
//        if (users.isEmpty()) {
//            throw new RuntimeException("User list empty!");
//        }
        return users.stream().map(this::toUserDto).toList();
    }

    private UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .age(user.getAge())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .build();
    }

    public Long update(UserDto dto) {
        User user = client.get(String.valueOf(dto.getId()));
        User build = User.builder()
                .id(dto.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .age(dto.getAge())
                .firstname(dto.getFirstName())
                .lastname(dto.getLastName())
                .build();
        return client.save(build);
    }
}
