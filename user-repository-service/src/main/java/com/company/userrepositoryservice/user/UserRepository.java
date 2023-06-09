package com.company.userrepositoryservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 19:19
 * microservie-task
 */

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "from User where username = :username")
    Optional<User> findByUsername(@Param(value = "username") String username);
}
