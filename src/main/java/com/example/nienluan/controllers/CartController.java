package com.example.nienluan.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/cart")
public class CartController {
  @GetMapping
  public ResponseEntity<List<String>> getCart(@RequestParam int unit){
   List<String> messages =  new ArrayList<>();
    for (int i = 0; i<unit; i++){
      messages.add(String.format("This is message %d", i));
    }
    return ResponseEntity.ok(messages);
  }
}
