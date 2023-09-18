package com.example.nienluan.models;

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
@Table(name ="CartItem")
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column
  private int quantity;
  @Column(name = "totalPrice")
  private double totalPrice;

  @ManyToOne
  @JoinColumn(name = "id_Cart")
  private Cart cart;

  @OneToOne
  @JoinColumn(name = "id_Phone")
  private Phone phone;
}
