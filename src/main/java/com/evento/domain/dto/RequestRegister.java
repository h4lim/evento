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
public class RequestRegister {

    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("email")
    private String email;

}
