package com.sanskar.project.bookstore.services;

import com.sanskar.project.bookstore.dto.BooksDTO;
import com.sanskar.project.bookstore.dto.OrdersDTO;
import com.sanskar.project.bookstore.dto.UserDTO;
import com.sanskar.project.bookstore.entity.BooksEntity;
import com.sanskar.project.bookstore.entity.OrdersEntity;
import com.sanskar.project.bookstore.entity.UserEntity;
import com.sanskar.project.bookstore.repository.OrdersRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepo ordersRepo;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final BooksService booksService;

    public OrdersService(OrdersRepo ordersRepo, ModelMapper modelMapper, UserService userService, BooksService booksService) {
        this.ordersRepo = ordersRepo;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.booksService = booksService;
    }

    public OrdersDTO addNewOrder(OrdersDTO ordersDTO) {
        UserDTO userDTO = userService.getUserById(ordersDTO.getUserId());
        BooksDTO booksDTO = booksService.getBookById(ordersDTO.getBookId());

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setId(ordersDTO.getId());
        ordersEntity.setBook(modelMapper.map(booksDTO, BooksEntity.class));
        ordersEntity.setUser(modelMapper.map(userDTO, UserEntity.class));
        ordersEntity.setStatus(ordersDTO.getStatus());
        ordersEntity.setQuantity(ordersDTO.getQuantity());
        ordersEntity.setAddress(ordersDTO.getAddress());
        ordersRepo.save(ordersEntity);
        return modelMapper.map(ordersEntity, OrdersDTO.class);
    }

    public List<OrdersEntity> getAllOrders() {
        return new ArrayList<>(ordersRepo.findAll());
    }
}
