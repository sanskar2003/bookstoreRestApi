package com.sanskar.project.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
    private Long id;
    private Long bookId;
    private Long userId;
    private String status;
    private int quantity;
    private String address;
}
