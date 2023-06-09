package com.company.userservice.dto;

import lombok.*;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 18:25
 * microservie-task
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String firstName;
    private String lastName;
}
