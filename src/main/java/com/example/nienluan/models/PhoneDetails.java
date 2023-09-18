package com.example.nienluan.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Phone_Details")
@Data
public class PhoneDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_PhoneDetails", nullable = false)
  private Long id;


  @OneToOne
  @JoinColumn(name="id_Phone")
  private Phone id_phone;


}
