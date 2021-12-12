package com.evento.usecase;

import com.evento.domain.contract.EventoContract;
import com.evento.domain.dto.*;
import com.evento.domain.model.Account;
import com.evento.helper.CommonHelper;
import com.evento.helper.ModelHelper;
import com.evento.helper.RestHelper;
import com.evento.infrastructure.contract.InstanceContract;
import com.evento.repository.jpa.AccountJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

@Service
public class EventoUseCase implements EventoContract.IEventoUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventoUseCase.class);

    private final AccountJpa accountJpa;

    private final EventoContract.IWaService iWaService;

    @Autowired
    public EventoUseCase(AccountJpa accountJpa, EventoContract.IWaService iWaService) {
        this.accountJpa = accountJpa;
        this.iWaService = iWaService;
    }

    @Override
    public ResponseEntity<GenericResponse> registerUseCase(RequestRegister request) {

        if (StringUtils.isEmpty(request.getMsisdn())) {
            return new ResponseEntity<>(RestHelper.toResponse(
                    "8", "Msisdn cannot be empty"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(request.getEmail())) {
            return new ResponseEntity<>(RestHelper.toResponse(
                    "8", "Email cannot be empty"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(request.getFullName())) {
            return new ResponseEntity<>(RestHelper.toResponse(
                    "8", "Full name cannot be empty"), HttpStatus.BAD_REQUEST);
        }

        Account account = accountJpa.findByMsisdnOrEmail(request.getMsisdn(), request.getEmail());
        if (account != null) {
            return new ResponseEntity<>(RestHelper.toResponse(
                    "8", "Account already registered"), HttpStatus.BAD_REQUEST);
        }

        accountJpa.save(ModelHelper.setModel(request));
        return new ResponseEntity<>(RestHelper.toResponse(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> requestOtpUseCase(HttpHeaders headers, RequestOtp request) {

        String otp = CommonHelper.generateOtp();
        String response = iWaService.sendOtp(request.getMsisdn(), "Your OTP is " + otp);
       // iJedisInstance.jedis().set(request.getMsisdn() + "OTP", otp);
        LOGGER.info("OTP ", otp);
        LOGGER.info(response);
        return new ResponseEntity<>(RestHelper.toResponse(), HttpStatus.ACCEPTED);
    }

    @Override
    @NotNull
    public ResponseEntity<GenericResponseData> loginUseCase(HttpHeaders headers, RequestLogin request) {
      //  iJedisInstance.jedis().set(request.getMsisdn() + "SESSION_ID", CommonHelper.generateSessionID());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponseData> getAccountUseCase(HttpHeaders headers, String msisdn) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
