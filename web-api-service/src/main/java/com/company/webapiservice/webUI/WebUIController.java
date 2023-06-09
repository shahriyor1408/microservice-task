package com.company.webapiservice.webUI;

import com.company.webapiservice.webUI.dtos.UserCreateDto;
import com.company.webapiservice.webUI.dtos.UserDto;
import com.company.webapiservice.webUI.dtos.UserLoginDto;
import com.company.webapiservice.webUI.dtos.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 17:59
 * microservie-task
 */

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class WebUIController {

    private final WebUIService service;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@Valid @RequestBody UserLoginDto dto) {
        return service.login(dto);
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@Valid @RequestBody UserCreateDto dto) {
        return service.register(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable String id) {
        return service.get(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@Valid @RequestBody UserUpdateDto dto, @PathVariable String id) {
        return service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
