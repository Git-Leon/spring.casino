package com.zipcodewilmington.casino.services;

import com.zipcodewilmington.casino.models.Account;
import com.zipcodewilmington.casino.repositories.AccountRepository;
import com.zipcodewilmington.springutils.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<Account, Long> {
    @Autowired
    public AccountService(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account create() {
        return super.create(new Account());
    }

    @Override
    public Account update(Long id, Account newAccountData){
        Account originalAccount = repository.findById(id).get();
        originalAccount.setName(newAccountData.getName());
        originalAccount.setBalance(newAccountData.getBalance());
        return  repository.save(originalAccount);
    }

    public Account increaseBalance(Long id, Double funds) {
        Account account = read(id);
        account.setBalance(account.getBalance() + funds);
        return update(id, account);
    }

}
