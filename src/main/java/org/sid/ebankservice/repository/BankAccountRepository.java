package org.sid.ebankservice.repository;

import org.sid.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
=======

>>>>>>> c8517da (v1.0)
public interface BankAccountRepository extends JpaRepository<BankAccount , String> {
}
