package org.sid.ebankservice.web;

import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;

    //CRéation d'un constructeur qui est plus recommander dans la pratique que l'annotation @Autowired

    public BankAccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    //Création d'une liste de compte qui nous permettra d'afficher tous les comptes qui sont présents
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    //Consultation d'un compte sachant son id
    @GetMapping("/bankAccounts/{id}")
    public BankAccount getAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));

    }


}
