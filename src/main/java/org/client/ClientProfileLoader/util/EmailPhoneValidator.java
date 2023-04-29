package org.client.ClientProfileLoader.util;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailPhoneValidator {

    @Schema(description = "Email validation by RFC 5322")
    public boolean validateEmail(String contact) {
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(contact);
        return matcher.matches();
    }

    @Schema(description = "Phone number validation with using multiple regular expressions")
    public boolean validatePhoneNumber(String contact) {
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(contact);
        return matcher.matches();
    }
}
