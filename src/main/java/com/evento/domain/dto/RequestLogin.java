package com.evento.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class RequestLogin {

    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("otp")
    private String otp;
}
