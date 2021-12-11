package com.evento.service;

import com.evento.avro.Email;

/**
 * The interface Email service.
 */
public interface IEmailService {

    /**
     * Send email.
     *
     * @param email the email
     */
    void sendEmail(Email email);
}
