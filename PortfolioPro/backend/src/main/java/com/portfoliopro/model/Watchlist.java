package com.portfoliopro.model;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="watchlists", uniqueConstraints=@UniqueConstraint(columnNames={"user_id","stock_id"})) @Getter @Setter @NoArgsConstructor
public class Watchlist { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; @ManyToOne User user; @ManyToOne Stock stock; public Watchlist(User u,Stock s){user=u;stock=s;} }
