package com.company.webapiservice.webUI.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 18:36
 * microservie-task
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AppErrorResponse {
    private String friendlyMessage;
    private String developerMessage;
    private String path;
    private Map<String, ?> fields;
    private int code;
    @Builder.Default
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()));

}
