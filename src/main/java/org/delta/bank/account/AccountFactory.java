package org.delta.bank.account;

import org.delta.bank.persons.Owner;
//import print.PrintService;

public class AccountFactory {
    private final AccountNumberGenerator accountNumberGeneratorService;

    public AccountFactory() {
        this.accountNumberGeneratorService = new AccountNumberGenerator();
    }

    public BaseBankAccount createBaseBankAccount(Owner owner, Double balnce) {
        String bankAccountNumber = accountNumberGeneratorService.generateAccountNumber();
        return new BaseBankAccount(owner, bankAccountNumber, balnce);
    }

    public SaveBankAccount createSavingBankAccount(Owner owner, Double balnce) {
        String bankAccountNumber = accountNumberGeneratorService.generateAccountNumber();
        return new SaveBankAccount(owner, bankAccountNumber, balnce);
    }

    public StudentBankAccount createStudentBankAccount(Owner owner, Double balnce) {
        String bankAccountNumber = accountNumberGeneratorService.generateAccountNumber();
        return new StudentBankAccount(owner, bankAccountNumber, balnce);
    }
}