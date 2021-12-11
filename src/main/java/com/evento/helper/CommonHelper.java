package com.evento.helper;

import com.evento.domain.dto.GenericResponse;

import java.sql.Timestamp;
import java.util.Random;

public class CommonHelper {

    public static Timestamp generateTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static GenericResponse generateResponseSuccess() {
        return new GenericResponse("0",
                "Success", true, generateTimestamp());
    }

    public static String generateOtp() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
