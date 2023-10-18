package org.delta.bank.persons;

public class OwnerFactory {
    public static Owner createOwner(String firstName, String lastName) {
        return new Owner(firstName, lastName);
    }
}
