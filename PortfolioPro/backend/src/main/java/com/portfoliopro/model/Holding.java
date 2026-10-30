package com.portfoliopro.model;

import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="holdings", uniqueConstraints=@UniqueConstraint(columnNames={"user_id","stock_id"})) @Getter @Setter @NoArgsConstructor
public class Holding {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private User user;
 @ManyToOne(optional=false) private Stock stock;
 @Column(nullable=false) private int quantity;
 @Column(nullable=false) private double averageCost;
 public Holding(User user,Stock stock,int quantity,double averageCost){this.user=user;this.stock=stock;this.quantity=quantity;this.averageCost=averageCost;}
}
