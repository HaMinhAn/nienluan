package com.example.nienluan.controllers;

import com.example.nienluan.dto.PhoneRequest;
import com.example.nienluan.dto.PhoneResponse;
import com.example.nienluan.models.Phone;
import com.example.nienluan.services.impls.PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.net.URI;

@RestController
@RequestMapping("/phone")
public class PhoneController {


  @Autowired
  private PhoneServiceImpl phoneService;
  @GetMapping()
  public ResponseEntity<Page<Phone>> getPhones(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){

    return ResponseEntity.ok(phoneService.getPhones(page,size));
  }

  @PostMapping()
  public  ResponseEntity<PhoneResponse> addPhone(@RequestBody PhoneRequest phoneRequest ){
    System.out.println(phoneRequest.getDescription());
    PhoneResponse phoneResponse = phoneService.addPhone(phoneRequest);

    return ResponseEntity.created(URI.create("/phone" + phoneResponse.getId())).body(phoneResponse);
  }

  @GetMapping("/manufacturer")
  public ResponseEntity<Page<Phone>> getListPhoneByManufacturer(@RequestParam Integer id
          , @RequestParam(defaultValue = "0") int page
          , @RequestParam(defaultValue = "10") int size){
    Page<Phone> phones = phoneService.getListPhoneByManufacturer( id,  page,  size);
  return ResponseEntity.ok(phones);
  }
}
