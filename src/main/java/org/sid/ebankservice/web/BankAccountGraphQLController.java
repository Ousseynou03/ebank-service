package org.sid.ebankservice.web;

import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    //Injection du repository
    private final BankAccountRepository bankAccountRepository;

    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    //Récupération des comptes
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).
                orElseThrow(()-> new RuntimeException(String.format("Account % not found", id)));
    }
}
