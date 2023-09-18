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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_Order")
  private long id;
  @ManyToOne
  @JoinColumn(name = "id_User")
  private User user;
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date OrderDate;
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date ShipDate;
  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date DeliveryDate;
  @Column
  private String OrderStatus;
  @OneToOne
  @JoinColumn(name = "id_Payment")
  private Paymentmethod paymentmethod;
  private double totalPrice;
  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderDetail> orderDetailList;

  public String formatVND(long amount) {
    NumberFormat formatter = new DecimalFormat("#,###");
    return formatter.format(amount) + " VNĐ";
  }
}
