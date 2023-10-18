package org.delta.bank;

import org.delta.bank.account.*;
import org.delta.bank.interest.InterestService;
import org.delta.bank.moneyTransfer.MoneyTransferService;
import org.delta.bank.persons.Owner;
import org.delta.bank.persons.OwnerFactory;
import org.delta.bank.print.PrintService;

import java.util.LinkedList;
import java.util.List;

public class Bank {

    private final AccountFactory accountFactory;
    private final OwnerFactory ownerFactory;
    private MoneyTransferService moneyTransferService;
    private InterestService interestService;
    private PrintService printService;

    public Bank() {
        this.moneyTransferService = new MoneyTransferService();
        this.interestService = new InterestService();
        this.printService = new PrintService();
        this.accountFactory = new AccountFactory();
        this.ownerFactory = new OwnerFactory();
    }

    public void run() throws Exception {
        this.printService.debug("Hello bank");
        List<BaseBankAccount> accountsList = new LinkedList<>();

        Owner owner = ownerFactory.createOwner("Jakub", "Klucky");
        StudentBankAccount bankAccount = accountFactory.createStudentBankAccount(owner,4000.0);

        Owner owner2 = ownerFactory.createOwner("Jakub", "Klucky");
        BaseBankAccount bankAccount2 = accountFactory.createBaseBankAccount(owner2,5000.0);

        accountsList.add(bankAccount);
        accountsList.add(bankAccount);

        this.printService.printBankAccountBalance(bankAccount);
        this.printService.printBankAccountBalance(bankAccount2);



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
