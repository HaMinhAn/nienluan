package com.example.nienluan.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phone")
public class Phone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Phone", nullable = false)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "chip")
  private String chip;

  @Column(name = "ram")
  private int ram;

  @Column(name = "rom")
  private int rom;

  @Column(name = "size")
  private double size;

  @Column(name = "description", columnDefinition = "nvarchar(max)")
  private String description;
  @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_Manufacturer")
  @JsonBackReference
  private Manufacturer manufacturer;

  @OneToMany(mappedBy = "phone_id",fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Picture> pictures;

  @OneToOne
  @JoinColumn(name = "id_Category")
  private Category category;
  @Column(name = "Price")
  private Long price;
}
