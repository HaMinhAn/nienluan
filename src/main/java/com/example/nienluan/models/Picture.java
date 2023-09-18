package com.example.nienluan.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Picture")
@Data
public class Picture {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Picture")
  private Long id;

  @Column(name = "Caption")
  private String caption;

  @Column(name = "Image_Path")
  private String imagePath;

  @OneToOne
  @JoinColumn(name = "id_Phone")
  private Phone phone;
}
