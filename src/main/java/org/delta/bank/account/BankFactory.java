package org.delta.bank.account;

//import org.bank.logger.LogService;
import org.delta.bank.account.AccountNumberGenerator;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SaveBankAccount;
import org.delta.bank.account.StudentBankAccount;
import org.delta.bank.persons.Owner;

public class BankFactory {


//    private LogService logService;
    private AccountNumberGenerator accountNumberGenerator;


    public BankFactory(){
        //print service
//        this.logService = new LogService();
        this.accountNumberGenerator = new AccountNumberGenerator();
    }

    public BaseBankAccount createBaseBankAccount(Owner owner, int balance){
        // return Owner(name, lastName);
//        this.logService.logMessage("Debug... ");
        String newAccountNumber = this.accountNumberGenerator.generateAccountNumber();
        return  new BaseBankAccount(owner, newAccountNumber, balance);
    }

    public SaveBankAccount createSavingAccount(Owner owner, int balance){
        // return Owner(name, lastName);
//        this.logService.logMessage("Debug... ");
        String newAccountNumber = this.accountNumberGenerator.generateAccountNumber();
        return  new SaveBankAccount(owner, newAccountNumber, balance);
    }

    public StudentBankAccount createStudentAccount(Owner owner, int balance){
        // return Owner(name, lastName);
//        this.logService.logMessage("Debug... ");
        String newAccountNumber = this.accountNumberGenerator.generateAccountNumber();
        return  new StudentBankAccount(owner, newAccountNumber, balance);
    }


}
