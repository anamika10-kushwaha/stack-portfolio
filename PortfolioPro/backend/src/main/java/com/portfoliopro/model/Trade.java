package com.portfoliopro.model;

import jakarta.persistence.*; import lombok.*; import java.time.LocalDateTime;
@Entity @Table(name="trades") @Getter @Setter @NoArgsConstructor
public class Trade {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private User user; @ManyToOne(optional=false) private Stock stock;
 @Enumerated(EnumType.STRING) private Side side; private int quantity; private double price; private double totalValue; private LocalDateTime executedAt;
 public enum Side { BUY, SELL }
}
