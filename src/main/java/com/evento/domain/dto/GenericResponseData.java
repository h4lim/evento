package com.evento.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
public class GenericResponseData<T> {

    @JsonProperty("response_code")
    private String responseCode;

    @JsonProperty("response_message")
    private String responseMessage;

    @JsonProperty("response_status")
    private boolean responseStatus;

    @JsonProperty("response_timestamp")
    private Timestamp responseTimestamp;

    @JsonProperty("data")
    private T data;
}
