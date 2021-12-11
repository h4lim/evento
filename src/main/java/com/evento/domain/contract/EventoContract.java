package com.evento.domain.contract;

import com.evento.avro.Email;
import com.evento.domain.dto.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class EventoContract {

    public interface IEventoDelivery {
        ResponseEntity<ResponseDTO> sendMessageToKafkaTopic(EmailDTO email);

        ResponseEntity<GenericResponse> registerDelivery(HttpHeaders headers, RequestRegister request);

        ResponseEntity<GenericResponse> requestOtpDelivery(HttpHeaders headers, RequestOtp request);

        ResponseEntity<GenericResponseData> loginDelivery(HttpHeaders headers, RequestLogin request);

        ResponseEntity<GenericResponseData> getAccountDelivery(HttpHeaders headers, String msisdn);
    }

    public interface IEventoUseCase {
        ResponseEntity<GenericResponse> registerUseCase(RequestRegister request);

        ResponseEntity<GenericResponse> requestOtpUseCase(HttpHeaders headers, RequestOtp request);

        ResponseEntity<GenericResponseData> loginUseCase(HttpHeaders headers, RequestLogin request);

        ResponseEntity<GenericResponseData> getAccountUseCase(HttpHeaders headers, String msisdn);
    }

    public interface IEmailPublisherHandler {
        void sendMessage(Email email);
    }

    public interface IEmailSubscriberHandler {
        void consume(Email email);
    }

    public interface IWaService {
        String sendOtp(String msisdn, String message);
    }
}
