package org.sid.ebankservice.web;

import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.repository.BankAccountRepository;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;

    //Création d'un constructeur qui est plus recommander dans la pratique que l'annotation @Autowired
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;

    //CRéation d'un constructeur qui est plus recommander dans la pratique que l'annotation @Autowired
>>>>>>> c8517da (v1.0)

    public BankAccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    //Création d'une liste de compte qui nous permettra d'afficher tous les comptes qui sont présents
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
<<<<<<< HEAD

=======
>>>>>>> c8517da (v1.0)
        return bankAccountRepository.findAll();
    }

    //Consultation d'un compte sachant son id
    @GetMapping("/bankAccounts/{id}")
    public BankAccount getAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));

    }

<<<<<<< HEAD
    //Ajout de compte
    //Test avec Postman
    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }

    //Mise à jour
    @PutMapping("/bankAccounts{id}")
    public BankAccount update(@PathVariable BankAccount bankAccount, String id){
        bankAccount.setId(id);
        return bankAccountRepository.save(bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

=======
>>>>>>> c8517da (v1.0)

}
