package com.evento.helper;

import com.evento.domain.dto.RequestRegister;
import com.evento.domain.model.Account;
import com.evento.infrastructure.configuration.ApplicationConstant;

import java.sql.Timestamp;

public class ModelHelper {

    public static Account setModel(RequestRegister request) {

        Account account = new Account();
        account.setMsisdn(request.getMsisdn());
        account.setEmail(request.getEmail());
        account.setFullName(request.getFullName());

        Timestamp newTimestamp = CommonHelper.generateTimestamp();
        account.setCreatedBy(ApplicationConstant.BaseEntityConstant.BY_SYSTEM);
        account.setCreatedDate(newTimestamp);
        account.setUpdatedBy(ApplicationConstant.BaseEntityConstant.BY_SYSTEM);
        account.setUpdatedDate(newTimestamp);

        return account;
    }


}
