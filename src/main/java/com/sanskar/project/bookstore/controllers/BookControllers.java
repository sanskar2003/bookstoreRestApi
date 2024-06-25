package com.sanskar.project.bookstore.controllers;

import com.sanskar.project.bookstore.dto.BooksDTO;
import com.sanskar.project.bookstore.services.BooksService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookControllers {
    private final BooksService booksService;

    public BookControllers(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping
    public BooksDTO addNewBook(@RequestBody BooksDTO booksDTO){
        return booksService.addNewBook(booksDTO);
    }

    @GetMapping
    public List<BooksDTO> getAllBooks(@PathParam("title") String title, @PathParam("author") String author, @PathParam("genre") String genre){
        return booksService.findBooksByCustomCriteria(title, author, genre);
    }

    @GetMapping("/{id}")
    public BooksDTO getBookById(@PathVariable("id") Long bookId){
        return booksService.getBookById(bookId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable("id") Long bookId){
        return booksService.deleteBookById(bookId);
    }

    @PutMapping("update/{id}")
    public BooksDTO updateBookById(@PathVariable("id") Long bookId, @RequestBody BooksDTO booksDTO){
        return booksService.updateBookById(bookId, booksDTO);
    }
}
