package com.example.nienluan.controllers;

import com.example.nienluan.dto.AddItems;
import com.example.nienluan.models.Cart;
import com.example.nienluan.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/cart")
public class CartController {
  @Autowired
  private BasketService basketService;

  @GetMapping("/{id}")
  public ResponseEntity<Cart> getBasket(@PathVariable Integer id) throws ExecutionException, InterruptedException {
    return ResponseEntity.ok(basketService.getBasket(id));
  }

  @PostMapping("/add")
  public void addToBasket(@RequestBody AddItems req){
    basketService.add(req);
  }

  @PutMapping("/remove")
  public void removeItem(@RequestBody AddItems req){
    basketService.remove(req);
  }
  @DeleteMapping("/remove/item/{id}")
  public String removeItem(@PathVariable int id, @RequestParam Integer name) {
    return basketService.removeItem(id,name);
  }
  @DeleteMapping("/delete/{name}")
  public String deleteBasket(@PathVariable int name) {
    return basketService.delete(name);
  }
}
