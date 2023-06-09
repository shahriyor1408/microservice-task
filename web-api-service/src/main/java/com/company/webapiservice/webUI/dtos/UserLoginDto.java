package com.company.webapiservice.webUI.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 18:27
 * microservie-task
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginDto {

    @NotBlank(message = "Username can not be blank!")
    @NotNull(message = "Username can not be null!")
    private String username;

    @NotBlank(message = "Password can not be blank!")
    @NotNull(message = "Username can not be null!")
    private String password;
}
