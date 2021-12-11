package com.evento.repository.jpa;

import com.evento.domain.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpa extends CrudRepository<Account, Long> {

    Account findByMsisdnOrEmail(String msisdn, String email);

}
