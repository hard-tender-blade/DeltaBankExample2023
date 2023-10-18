package org.delta.bank.account;

import org.delta.bank.account.BankFactory;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.persons.Owner;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String, BaseBankAccount> accounts;
    private BankFactory bankFactory;

    public AccountService(){
        this.accounts = new HashMap<>();
        this.bankFactory = new BankFactory();
    }

    public BaseBankAccount createAndStoreBasedBankAccount(Owner owner, int balance){
        BaseBankAccount bankAccount = this.bankFactory.createBaseBankAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        return bankAccount;
    }

    public StudentBankAccount createAndStoreStudentAccount(Owner owner, int balance){
        StudentBankAccount bankAccount = this.bankFactory.createStudentAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        return bankAccount;
    }

    public SaveBankAccount createAndStoreSavingAccount(Owner owner, int balance){
        SaveBankAccount bankAccount = this.bankFactory.createSavingAccount(owner, balance);
        this.accounts.put(bankAccount.getAccountNumber(), bankAccount);
        return bankAccount;
    }

    public Map<String, BaseBankAccount> getAccounts(){
        return accounts;
    }
}
