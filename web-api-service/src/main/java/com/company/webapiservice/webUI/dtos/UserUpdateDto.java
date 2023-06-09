package com.company.webapiservice.webUI.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 18:52
 * microservie-task
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto {

    @NotNull(message = "Age can not be null!")
    private Integer age;

    @NotBlank(message = "Firstname can not be blank!")
    @NotNull(message = "Firstname can not be null!")
    private String firstName;

    @NotBlank(message = "Lastname can not be blank!")
    @NotNull(message = "Lastname can not be null!")
    private String lastName;
}
