package org.delta.bank.account;

import jakarta.inject.Inject;
import org.delta.bank.persons.Owner;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, BaseBankAccount> accounts;
    @Inject
    private AccountFactory accountFactory;

    public AccountService(){
        this.accounts = new HashMap<>();
    }

    public BaseBankAccount createAndStoreBasedBankAccount(Owner owner, double balance){
        BaseBankAccount bankAccount = this.accountFactory.createBaseBankAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        return bankAccount;
    }

    public StudentBankAccount createAndStoreStudentAccount(Owner owner, double balance){
        StudentBankAccount bankAccount = this.accountFactory.createStudentBankAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        return bankAccount;
    }

    public SaveBankAccount createAndStoreSavingAccount(Owner owner, double balance){
        SaveBankAccount bankAccount = this.accountFactory.createSavingBankAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        return bankAccount;
    }

    public Map<String, BaseBankAccount> getAccounts(){
        return accounts;
    }
}
