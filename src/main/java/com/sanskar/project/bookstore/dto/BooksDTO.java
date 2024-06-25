package com.sanskar.project.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksDTO {
    private Long id;
    private String title;
    private String author;
    private String desc;
    private int price;
    private boolean isAvailable;
    private String genre;
}
