package com.sanskar.project.bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BooksEntity book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    private String status;
    private int quantity;
    private String address;
}
