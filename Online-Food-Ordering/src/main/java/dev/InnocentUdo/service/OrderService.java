package dev.InnocentUdo.service;

import dev.InnocentUdo.DTO.request.OrderRequest;
import dev.InnocentUdo.model.Order;
import dev.InnocentUdo.model.User;

import java.util.List;

public interface OrderService {
    public Order createOrder(OrderRequest order, User user) throws Exception;
    public Order updateOrder(Long orderId, String orderStatus) throws Exception;
    public void cancelOrder(Long orderId) throws Exception;
    public List<Order> getUsersOrder(Long userId) throws Exception;
    public List<Order> getRestaurantsOrder(Long restaurantId, String orderStatus) throws Exception;
    public Order findOrderById(Long orderId) throws Exception;
}
