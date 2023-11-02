package org.delta.bank.persons;

public class OwnerJsonService {
    public String getOwnerJson(Owner owner) {
        return "{\"firstName\":\"" + owner.getFirstName() + "\",\"lastName\":\"" + owner.getLastName() + "\"}";
    }
}
