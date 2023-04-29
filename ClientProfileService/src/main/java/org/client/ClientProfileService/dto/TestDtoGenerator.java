package org.client.ClientProfileService.dto;

import org.client.ClientProfileService.entity.Enums.Status;
import org.client.ClientProfileService.entity.Individual;
import org.client.ClientProfileService.entity.RFPassport;
import org.springframework.stereotype.Component;
import java.util.UUID;
import static org.client.ClientProfileService.entity.Enums.Status.values;

@Component
public class TestDtoGenerator {

    private Status getStatus() {
        return values()[(int) (Math.random() * values().length)];
    }

    private String randomUUID() {
        return String.valueOf(UUID.randomUUID());
    }

    public Individual generateIndividual(String icp, String uuid) {
        return new Individual(icp, uuid, null, null, null, null, null,
                null, null, null, null, getStatus(), null,
                null, null, null, null, null);
    }

    public RFPassport generatePassport() {
        return new RFPassport(randomUUID(), null, null, null, null,
                null, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null);
    }
}
