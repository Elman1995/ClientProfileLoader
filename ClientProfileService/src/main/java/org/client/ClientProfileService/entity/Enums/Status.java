package org.client.ClientProfileService.entity.Enums;

public enum Status {
    CREATED, // создан
    LOADED, // загружен другим сервисом
    WAITING, // ожидает загрузки другим сервсом
    UPDATED, // обновлен
	ARCHIVED // в архиве

}
