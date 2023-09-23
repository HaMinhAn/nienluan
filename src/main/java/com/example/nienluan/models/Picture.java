package com.example.nienluan.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Picture")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Picture {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Picture")
  private Integer id;

  @Column(name = "Caption")
  private String caption;

  @Column(name = "Image_Path")
  private String imagePath;

  @ManyToOne
  @JoinColumn(name = "id_Phone")
  @JsonBackReference
  private Phone phone_id;
}
