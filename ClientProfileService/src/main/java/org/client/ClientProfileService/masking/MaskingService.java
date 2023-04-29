package org.client.ClientProfileService.masking;

public interface MaskingService {

    String maskName(String name, String surname, String patronymic);

    String maskPhone(String phone);

    String maskPassport(String series, String number);
}
