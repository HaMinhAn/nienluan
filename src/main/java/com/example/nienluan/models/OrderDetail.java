package com.example.nienluan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_order_detail")
  private long id;
  @Column(name="quantity")
  private int quantity;
  @Column(name="totalPrice")
  private long totalPrice;
  @Column(name="unitPrice")
  private long unitPrice;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_Order")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "id_Phone")
  private Phone phone;
  public String formatVND(long amount) {
    NumberFormat formatter = new DecimalFormat("#,###");
    return formatter.format(amount) + " VNĐ";
  }
}
