package org.delta.bank.interest;

import jakarta.inject.Inject;
import org.delta.bank.account.BaseBankAccount;

public class InterestService {
    @Inject
    private InterestCalculator interestCalculator;

    public void processInterest(BaseBankAccount bankAccount) {
        double interest = this.interestCalculator.calculateInterest(bankAccount);
        System.out.println("interest: " + interest);
        bankAccount.addToBalance(interest);
    }

}
