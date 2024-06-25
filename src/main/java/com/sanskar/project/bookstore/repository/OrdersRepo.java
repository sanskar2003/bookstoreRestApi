package com.sanskar.project.bookstore.repository;

import com.sanskar.project.bookstore.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<OrdersEntity, Long> {
}
