package com.evento.service;

import com.evento.domain.contract.EventoContract;
import com.evento.infrastructure.configuration.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WaService implements EventoContract.IWaService {

    private final RestTemplate restTemplate;

    @Autowired
    public WaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String sendOtp(String msisdn, String message) {

        UriComponentsBuilder builder = UriComponentsBuilder.
                fromHttpUrl(ApplicationConstant.UrlConstant.WA_URL)
                .queryParam("phone", msisdn)
                .queryParam("text", message);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }


}
