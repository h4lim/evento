package com.evento.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Response dto.
 */
@Getter
@Setter
@ToString
@Builder
public class ResponseDTO {

    private String status;
    private String message;
}
