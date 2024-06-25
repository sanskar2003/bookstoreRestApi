package com.sanskar.project.bookstore.services;

import com.sanskar.project.bookstore.dto.BooksDTO;
import com.sanskar.project.bookstore.entity.BooksEntity;
import com.sanskar.project.bookstore.exception.ResourceNotFoundException;
import com.sanskar.project.bookstore.repository.BooksRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private final BooksRepo booksRepo;
    private final ModelMapper modelMapper;

    public BooksService(BooksRepo booksRepo, ModelMapper modelMapper) {
        this.booksRepo = booksRepo;
        this.modelMapper = modelMapper;
    }

    public List<BooksDTO> getAllBooks(){
        return booksRepo.findAll().stream()
                .map(booksEntity -> modelMapper.map(booksEntity, BooksDTO.class))
                .collect(Collectors.toList());
    }

    public BooksDTO addNewBook(BooksDTO booksDTO) {
        BooksEntity booksEntity = booksRepo.save(modelMapper.map(booksDTO, BooksEntity.class));
        return modelMapper.map(booksEntity, BooksDTO.class);
    }

    public BooksDTO getBookById(Long bookId) {
        BooksEntity bookEntity = booksRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book doesn't exist with id: " + bookId));
        return modelMapper.map(bookEntity, BooksDTO.class);
    }

    public String deleteBookById(Long bookId) {
        if(booksRepo.existsById(bookId)){
            booksRepo.deleteById(bookId);
            return "Book deleted successfully!";
        }else
            return "Book Doesn't exist!";
    }

    public BooksDTO updateBookById(Long bookId, BooksDTO booksDTO) {
        BooksEntity booksEntity = booksRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book doesn't exist with id: " + bookId));
        booksEntity.setAuthor(booksDTO.getAuthor());
        booksEntity.setDesc(booksDTO.getDesc());
        booksEntity.setTitle(booksDTO.getTitle());
        booksEntity.setPrice(booksDTO.getPrice());
        booksEntity.setAvailable(booksDTO.isAvailable());
        booksRepo.save(booksEntity);
        return modelMapper.map(booksEntity, BooksDTO.class);
    }

    public List<BooksDTO> findBooksByCustomCriteria(String title, String author, String genre) {
        return booksRepo.findBookByCustomFilter(title, author, genre).stream()
                .map(booksEntity -> modelMapper.map(booksEntity, BooksDTO.class))
                .collect(Collectors.toList());
    }
}
