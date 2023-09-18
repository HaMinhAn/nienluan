package com.example.nienluan.controllers;

import com.example.nienluan.dto.CreateRolesRequest;
import com.example.nienluan.models.Role;
import com.example.nienluan.repository.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/roles")
public class RoleController {
  private final RoleRepository roleRepository;

  public RoleController(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @GetMapping
  public String greeting(){
    return "Hi";
  }

  @PostMapping
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity createRole(@RequestBody CreateRolesRequest createRolesRequest){
    Role role = new Role();
    role.setName(createRolesRequest.getName());
    roleRepository.save(role);
    return ResponseEntity.ok().body("Tao thanh cong");
  }
}
