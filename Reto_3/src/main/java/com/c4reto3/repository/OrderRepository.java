package com.c4reto3.repository;

import com.c4reto3.model.Order;
import com.c4reto3.repository.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public List<Order> getAllOrders() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderCrudRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderCrudRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderCrudRepository.delete(order);
    }

    public Optional<Order> lastUserId() {
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zone) {
        return orderCrudRepository.findByZone(zone);
    }
}
