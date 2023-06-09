package com.company.webapiservice.webUI;

import com.company.webapiservice.webUI.client.UserServiceClient;
import com.company.webapiservice.webUI.dtos.UserCreateDto;
import com.company.webapiservice.webUI.dtos.UserDto;
import com.company.webapiservice.webUI.dtos.UserLoginDto;
import com.company.webapiservice.webUI.dtos.UserUpdateDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 17:59
 * microservie-task
 */

@Service
@RequiredArgsConstructor
public class WebUIService {
    private final UserServiceClient client;
    private final PasswordEncoder encoder;

    public ResponseEntity<UserDto> login(UserLoginDto dto) {
        UserDto userDto = client.findByUsername(dto.getUsername());
        if (Objects.isNull(userDto)) {
            throw new RuntimeException("User not found!");
        }
        if (!encoder.matches(dto.getPassword(), userDto.getPassword())) {
            throw new RuntimeException("Bad credentials!");
        }
        return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Long> register(UserCreateDto dto) {
        UserDto userDto = client.findByUsername(dto.getUsername());
        if (!Objects.isNull(userDto)) {
            throw new RuntimeException("Username already exist!");
        }
        UserDto build = UserDto.builder()
                .username(dto.getUsername())
                .password(encoder.encode(dto.getPassword()))
                .age(dto.getAge())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        return new ResponseEntity<>(client.save(build), HttpStatus.CREATED);
    }

    public ResponseEntity<UserDto> get(@NonNull String id) {
        UserDto userDto = client.get(id);
        if (Objects.isNull(userDto)) {
            throw new RuntimeException("User not found!");
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    public ResponseEntity<UserDto> update(UserUpdateDto dto, @NonNull String id) {
        if (client.checkById(id)) {
            throw new RuntimeException("User not found!");
        }
        UserDto build = UserDto.builder()
                .id(Long.parseLong(id))
                .age(dto.getAge())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        client.update(build);
        return new ResponseEntity<>(client.get(id), HttpStatus.OK);
    }

    public ResponseEntity<Long> delete(String id) {
        if (client.checkById(id)) {
            throw new RuntimeException("User not found!");
        }
        return new ResponseEntity<>(client.delete(id), HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(client.getAll(), HttpStatus.OK);
    }
}
