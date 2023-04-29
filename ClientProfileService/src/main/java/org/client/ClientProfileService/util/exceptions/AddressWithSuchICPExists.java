package org.client.ClientProfileService.util.exceptions;

public class AddressWithSuchICPExists extends RuntimeException {

    public AddressWithSuchICPExists(String message) {
        super(message);
    }
}
