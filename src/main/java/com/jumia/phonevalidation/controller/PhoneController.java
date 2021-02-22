package com.jumia.phonevalidation.controller;

import com.jumia.phonevalidation.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/phone", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<String>> getAllValidPhoneNumbers() {
                return ResponseEntity.ok(phoneService.getAllValidPhoneNumbers());
    }


}
