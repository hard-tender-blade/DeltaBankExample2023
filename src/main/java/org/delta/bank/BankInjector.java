package org.delta.bank;

import com.google.inject.AbstractModule;
import org.delta.bank.persons.OwnerJsonService;
import org.delta.bank.persons.OwnerJsonServiceInterface;
import org.delta.bank.print.ConsolePrintService;
import org.delta.bank.print.PrintInterface;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(PrintInterface.class).to(ConsolePrintService.class);
        this.bind(OwnerJsonServiceInterface.class).to(OwnerJsonService.class);
    }
}
