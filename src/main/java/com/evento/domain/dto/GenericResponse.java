package com.evento.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class GenericResponse {

    @JsonProperty("response_code")
    private String responseCode;

    @JsonProperty("response_message")
    private String responseMessage;

    @JsonProperty("response_status")
    private boolean responseStatus;

    @JsonProperty("response_timestamp")
    private Timestamp responseTimestamp;

}
