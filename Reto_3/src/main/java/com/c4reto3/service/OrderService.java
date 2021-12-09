package com.c4reto3.service;

import com.c4reto3.model.Order;
import com.c4reto3.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order createOrder(Order order) {

        // Obtiene el maximo id existente en la coleccion
        Optional<Order> maxOrderId = orderRepository.lastUserId();

        // Si el id de la orden que recibe como parametro es nulo, entonces valida
        // el maximo id existente en base de datos
        if (order.getId() == null) {
            // valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (maxOrderId.isEmpty()) {
                order.setId(1);
            } else {
                order.setId(maxOrderId.get().getId() + 1);
            }
        }

        Optional<Order> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.createOrder(order);
        } else {
            return order;
        }
    }

    public Order updateOrder(Order order) {

        if (order.getId() == null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (orderDb.isPresent()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.updateOrder(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean deleteOrder(int id) {
        return getOrder(id).map(order -> {
            orderRepository.deleteOrder(order);
            return true;
        }).orElse(false);
    }

    public List<Order> findByZone(String zone) {
        return orderRepository.findByZone(zone);
    }
}
