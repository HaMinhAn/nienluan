package com.example.nienluan.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
@Data
public class Phone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Phone", nullable = false)
  private Long id;

  @Column(name = "chip")
  private String chip;

  @Column(name = "ram")
  private int ram;

  @Column(name = "rom")
  private int rom;

  @Column(name = "size")
  private int size;

  @ManyToOne
  @JoinColumn(name = "id_Manufacturer")
  private Manufacturer manufacturer;

  @OneToOne
  @JoinColumn(name = "id_Category")
  private Category category;

  @Column(name = "Price")
  private Long price;
  @OneToOne(mappedBy = "phone")
  private Picture picture;
  @OneToOne(mappedBy = "id_phone")
  private PhoneDetails phoneDetails;
}
