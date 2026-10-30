package com.portfoliopro.model;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="users") @Getter @Setter @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, unique=true) private String email;
    @Column(nullable=false) private String name;
    @Column(nullable=false) private String passwordHash;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private Role role=Role.USER;
    @Column(nullable=false) private boolean active=true;
    @Column(nullable=false) private double cashBalance=100000.0;
    public User(String name,String email,String passwordHash){this.name=name;this.email=email;this.passwordHash=passwordHash;}
    public enum Role { USER, ADMIN }
}
