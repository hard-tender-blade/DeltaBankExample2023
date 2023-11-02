package org.delta.bank.interest;

import jakarta.inject.Inject;
import org.delta.bank.account.BaseBankAccount;

public class InterestCalculator {
    @Inject
    private InterestConfigLoader interestConfigLoader;
    public double calculateInterest(BaseBankAccount bankAccount) {

        double interest = this.interestConfigLoader.getInterest(bankAccount);

        return bankAccount.getBalance() * interest;
    }
}
