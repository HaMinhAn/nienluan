package com.example.nienluan.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Manufacturer")
public class Manufacturer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Manufacturer", nullable = false)
  private Long id;



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
