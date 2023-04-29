package org.client.ClientProfileService.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.client.ClientProfileService.dto.IndividualDto;
import org.client.ClientProfileService.service.IndividualService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/individual")
@Tag(name = "Individual controller", description = "Методы для работы с пользователем")
@AllArgsConstructor
public class IndividualController {
    private final IndividualService individualService;

    @GetMapping("/get")
    @Operation(summary = "Информация о клиенте по ICP")
    public ResponseEntity<IndividualDto> getById(@Parameter(required = true,
            description = "ICP уникальный ключ клиента") String icp) {
        return new ResponseEntity<>(individualService.getClient(icp), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createIndividual(@RequestBody IndividualDto dto) {
        individualService.addClient(dto);
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping("/contacts")
    public ResponseEntity<IndividualDto> getByPhoneNumber(@RequestParam("phonenumber") String phoneNumber) {
        return new ResponseEntity<>(individualService.getClientByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
}
