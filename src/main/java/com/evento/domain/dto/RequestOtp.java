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
public class RequestOtp {

    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("a")
    private String a;

}
