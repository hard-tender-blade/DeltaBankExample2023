package org.delta.bank.account;

import java.util.Random;

public class AccountNumberGenerator {
    public String generateAccountNumber() {

        Random random = new Random();
        int randomNumber = random.nextInt(999999) + 100000;
        String id = String.valueOf(randomNumber);

        return id;
    }
}
