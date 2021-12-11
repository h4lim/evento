package com.evento.handler;

import com.evento.avro.Email;
import com.evento.domain.contract.EventoContract;
import com.evento.infrastructure.configuration.ApplicationConstant;
import com.evento.service.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EmailSubscriberHandler implements EventoContract.IEmailSubscriberHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(EmailSubscriberHandler.class);

    private final IEmailService emailService;

    @Autowired
    public EmailSubscriberHandler(IEmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = ApplicationConstant.TOPIC_NAME, groupId = "group_id")
    public void consume(@Payload Email email) {

        LOGGER.info("Email to {} processing started.", email.getTo());
        emailService.sendEmail(email);

    }
}
