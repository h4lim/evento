package com.evento.delivery;

import com.evento.domain.contract.EventoContract;
import com.evento.domain.dto.*;
import com.evento.infrastructure.configuration.ApplicationConstant;
import com.evento.util.EmailUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/")
public class EventoDelivery implements EventoContract.IEventoDelivery {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventoDelivery.class);

    private final EventoContract.IEmailPublisherHandler iEmailPublisherHandler;
    private final EventoContract.IEventoUseCase iEventoUseCase;

    @Autowired
    public EventoDelivery(EventoContract.IEmailPublisherHandler iEmailPublisherHandler,
                          EventoContract.IEventoUseCase iEventoUseCase) {
        this.iEmailPublisherHandler = iEmailPublisherHandler;
        this.iEventoUseCase = iEventoUseCase;
    }

    /**
     * Send message to kafka topic response entity.
     *
     * @param email the email
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping(value = "/email")
    @ApiOperation(value = "send Email")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Email Accepted Successful"),
            @ApiResponse(code = 400, message = "Validation Error"),
            @ApiResponse(code = 500, message = "Server error occurred")})
    public ResponseEntity<ResponseDTO> sendMessageToKafkaTopic(@ApiParam("Email payload") @Valid @RequestBody EmailDTO email) {

        this.iEmailPublisherHandler.sendMessage(EmailUtil.BuildEmail(email));
        LOGGER.info("Email Accepted Successful");
        return ResponseEntity.accepted().body(
                ResponseDTO.builder()
                        .status(ApplicationConstant.ACCEPTED)
                        .message(ApplicationConstant.EMAIL_SUCCESSFULLY_ACCEPTED)
                        .build());

    }

    @Override
    @PostMapping("/register")
    @ApiOperation(value = "Register")
    public ResponseEntity<GenericResponse> registerDelivery(
            @ApiParam("Register payload")
            @RequestHeader HttpHeaders headers,
            @Valid @RequestBody RequestRegister request) {

        return iEventoUseCase.registerUseCase(request);
    }

    @Override
    @PostMapping("/request_otp")
    @ApiOperation(value = "Request OTP")
    public ResponseEntity<GenericResponse> requestOtpDelivery(
            @ApiParam("Request OTP payload")
            @RequestHeader HttpHeaders headers,
            @Valid @RequestBody RequestOtp request) {
        return iEventoUseCase.requestOtpUseCase(headers, request);
    }

    @Override
    @PostMapping("/login")
    @ApiOperation(value = "Login")
    public ResponseEntity<GenericResponseData> loginDelivery(
            @ApiParam("Request OTP payload")
            @RequestHeader HttpHeaders headers,
            @Valid @RequestBody RequestLogin request) {
        return iEventoUseCase.loginUseCase(headers, request);
    }

    @Override
    @GetMapping("get_account")
    @ApiOperation(value = "Get account")
    public ResponseEntity<GenericResponseData> getAccountDelivery(
            @ApiParam("Get Account payload")
            @RequestHeader HttpHeaders headers,
            @RequestParam(name = "msisdn") String msisdn) {
        return iEventoUseCase.getAccountUseCase(headers, msisdn);
    }


}
