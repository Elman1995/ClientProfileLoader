package org.client.ClientProfileLoader.util.exceptions;

public class ClientWithSuchICPExists extends RuntimeException {
    public ClientWithSuchICPExists(String message) {
        super(message);
    }
}
