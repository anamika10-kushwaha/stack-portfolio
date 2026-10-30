package com.portfoliopro.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="stocks") @Getter @Setter @NoArgsConstructor
public class Stock {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String symbol;
 @Column(nullable=false) private String companyName;
 private String exchange; private String sector; private double price; private double changePercent;
 public Stock(String symbol,String companyName,String exchange,String sector,double price,double changePercent){this.symbol=symbol;this.companyName=companyName;this.exchange=exchange;this.sector=sector;this.price=price;this.changePercent=changePercent;}
}
