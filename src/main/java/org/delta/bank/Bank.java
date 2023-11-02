package org.delta.bank;

import jakarta.inject.Inject;
import org.delta.bank.account.*;
import org.delta.bank.interest.InterestService;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.persons.Owner;
import org.delta.bank.persons.OwnerFactory;
import org.delta.bank.persons.OwnerJsonService;
import org.delta.bank.persons.OwnerJsonServiceInterface;
import org.delta.bank.print.PrintService;
import org.delta.bank.account.AccountService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Bank {

    @Inject
    private AccountService accountService;
    @Inject
    private AccountFactory accountFactory;
    @Inject
    private OwnerFactory ownerFactory;
    @Inject
    private MoneyTransferService moneyTransferService;
    @Inject
    private InterestService interestService;
    @Inject
    private PrintService printService;
    @Inject
    private OwnerJsonServiceInterface ownerJsonService;

    public void run() throws Exception {
        this.printService.debug("Hello bank");

        Owner owner = ownerFactory.createOwner("Jakub", "Klucky");
        printService.debug(ownerJsonService.getOwnerJson(owner));

        StudentBankAccount bankAccount = accountService.createAndStoreStudentAccount(owner,4000.0);

        Owner owner2 = ownerFactory.createOwner("Jakub", "Klucky");
        printService.debug(ownerJsonService.getOwnerJson(owner2));
        BaseBankAccount bankAccount2 = accountFactory.createBaseBankAccount(owner2,5000.0);

        this.printService.printBankAccountBalance(bankAccount);

        // wqdqwdq
        Map<String, BaseBankAccount> accounts = accountService.getAccounts();

        for(Map.Entry<String, BaseBankAccount> entrySet : accountService.getAccounts().entrySet()){
            BaseBankAccount account = entrySet.getValue();

            this.printService.printBankAccountBalance(account);

            if(account instanceof InterestAccount){
                this.interestService.processInterest(account);
                this.printService.printBankAccountBalance(account);
            }
        }





        // bank transfer
//        this.moneyTransferService.transferMoney(bankAccount, savingBankAccount, 2000);

//        this.printService.debug("Money transfer");
//        this.printService.printBankAccountBalance(bankAccount);
//        this.printService.printBankAccountBalance(savingBankAccount);
//        System.out.println();

        // ATM
//        this.printService.debug("ATM");
//        this.moneyTransferService.transferMoneyByATM(bankAccount, 100);
//        this.printService.printBankAccountBalance(bankAccount);
//        System.out.println();
//
//        StudentBankAccount studentAccount = new StudentBankAccount(owner, "1234567", 5000);
//        accountsList.add(studentAccount);
//
//        this.moneyTransferService.transferMoney(studentAccount, savingBankAccount, 200);
//
//        this.printService.debug("Student account transfer");
//        this.printService.printBankAccountBalance(studentAccount);
//        this.printService.printBankAccountBalance(savingBankAccount);
//
//        System.out.println();

//        this.printService.debug("Account list: interests start");
//        for (BaseBankAccount account : accountsList) {
//
//            if (account instanceof InterestAccount) {
//                this.printService.printBankAccountBalance(account);
//                this.interestService.processInterest(account);
//                this.printService.printBankAccountBalance(account);
//                System.out.println();
//            }
//        }
//        this.printService.debug("Account list: interests end");

    }

}
