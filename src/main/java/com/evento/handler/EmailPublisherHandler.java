package com.evento.handler;

import com.evento.avro.Email;
import com.evento.domain.contract.EventoContract;
import com.evento.infrastructure.configuration.ApplicationConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Email publisher.
 */
@Service
public class EmailPublisherHandler implements EventoContract.IEmailPublisherHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailPublisherHandler.class);

    private final KafkaTemplate<String, Email> kafkaTemplate;

    @Autowired
    public EmailPublisherHandler(KafkaTemplate<String, Email> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Send message.
     *
     * @param email the email
     */
    @Override
    public void sendMessage(Email email) {
        LOGGER.info("Email send to Process.");
        this.kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, email);
    }
}
