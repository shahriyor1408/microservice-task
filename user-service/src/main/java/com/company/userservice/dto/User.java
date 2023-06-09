package com.company.userservice.dto;

import lombok.*;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 06/06/23 19:14
 * microservie-task
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String firstname;
    private String lastname;
}
