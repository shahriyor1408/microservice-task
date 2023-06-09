package com.company.userrepositoryservice.user;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 19:10
 * microservie-task
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;
}
