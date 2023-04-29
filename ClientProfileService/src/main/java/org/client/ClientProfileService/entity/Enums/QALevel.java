package org.client.ClientProfileService.entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum QALevel {
    QA_LEVEL_0, // BLANC
    QA_LEVEL_1, // Basic Information
    QA_LEVEL_2, // emial and phone added
    QA_LEVEL_3, // Documents added
    QA_LEVEL_4; // All fields  -> CLIENT

    @JsonCreator
    @JsonValue
    public String toValue() {
        return String.valueOf(ordinal());
    }
}
