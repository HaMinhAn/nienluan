package com.example.nienluan.controllers;

import com.example.nienluan.models.Category;
import com.example.nienluan.models.Manufacturer;
import com.example.nienluan.repository.CategoryRepository;
import com.example.nienluan.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private ManufacturerRepository manufacturerRepository;
  @GetMapping
  public List<Manufacturer> getAll(){
    manufacturerRepository.findAll().forEach(manufacturer -> System.out.println(manufacturer.getPhones().get(0).getChip()));
    return manufacturerRepository.findAll();
  }
}
