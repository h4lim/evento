package com.evento.helper;

import com.evento.domain.dto.GenericResponse;

public class RestHelper {

    public static GenericResponse toResponse() {
        return new GenericResponse("0",
                "Success", true, CommonHelper.generateTimestamp());
    }

    public static GenericResponse toResponse(String responseCode, String responseMessage) {
        return new GenericResponse(responseCode,
                responseMessage, false, CommonHelper.generateTimestamp());
    }

}
