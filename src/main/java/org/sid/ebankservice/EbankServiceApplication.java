package org.sid.ebankservice;

import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.enums.AccountType;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankServiceApplication implements CommandLineRunner {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i= 0;i<10;i++){
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            bankAccount.setBalance(Math.random()*90000);
            bankAccount.setType(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT);
            bankAccount.setCurrency("MAD");

            bankAccountRepository.save(bankAccount);

        }
        bankAccountRepository.findAll().forEach(acc ->{
            System.out.println(acc.toString());
        });

    }
}
