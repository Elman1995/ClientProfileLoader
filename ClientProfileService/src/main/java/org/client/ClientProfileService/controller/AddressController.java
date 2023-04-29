package org.client.ClientProfileService.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.client.ClientProfileService.dto.AddressDto;
import org.client.ClientProfileService.service.AddressService;
import org.client.ClientProfileService.service.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/address")
@Slf4j
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @Autowired
    private Producer producer;

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam String icp) {
        return new ResponseEntity<>(addressService.getAddressClient(icp), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@Parameter(required = true) String icp, @RequestBody AddressDto dto) {
        addressService.addAddressForClient(icp, dto.getAddressName());

        try {
            addressService.addAddressForClient(icp, dto.getAddressName());
        } catch (NoSuchElementException e) {
            log.warn("Address name not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            producer.sendMessage(dto);
        } catch (NoSuchElementException e) {
            log.warn("The message was not sent");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
