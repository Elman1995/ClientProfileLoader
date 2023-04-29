package org.client.ClientProfileService.util.exceptions;

public class ClientWithSuchICPExists extends RuntimeException {

    public ClientWithSuchICPExists(String message) {
        super(message);
    }
}
