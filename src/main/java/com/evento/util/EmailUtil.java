package com.evento.util;

import com.evento.avro.Attachment;
import com.evento.avro.Email;
import com.evento.domain.dto.AttachmentDTO;
import com.evento.domain.dto.EmailDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Email util.
 */
public class EmailUtil {

    /**
     * Build email email.
     *
     * @param email the email
     * @return the email
     */
    public static Email BuildEmail(EmailDTO email) {

        List<Attachment> attachments = new ArrayList<Attachment>();
        if (!StringUtils.isEmpty(email.getAttachments()))
            for (AttachmentDTO attachment : email.getAttachments()) {
                attachments.add(Attachment.newBuilder()
                        .setName(attachment.getName())
                        .setAttachmentURI(attachment.getAttachmentURI())
                        .build());
            }

        return Email.newBuilder()
                .setFrom(email.getFrom())
                .setTo(email.getTo())
                .setBcc(email.getBcc())
                .setCc(email.getCc())
                .setSubject(email.getSubject())
                .setBody(email.getBody())
                .setAttachments(attachments)
                .build();
    }
}