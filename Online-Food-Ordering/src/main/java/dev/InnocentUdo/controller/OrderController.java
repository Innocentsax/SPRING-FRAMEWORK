package dev.InnocentUdo.controller;

import dev.InnocentUdo.DTO.request.OrderRequest;
import dev.InnocentUdo.DTO.response.PaymentResponse;
import dev.InnocentUdo.model.Order;
import dev.InnocentUdo.model.User;
import dev.InnocentUdo.service.OrderService;
import dev.InnocentUdo.service.PaymentService;
import dev.InnocentUdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderController {
    private OrderService orderService;
    private PaymentService paymentService;
    private UserService userService;

    @Autowired
    public OrderController(OrderService orderService, PaymentService paymentService, UserService userService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.userService = userService;
    }
    @PostMapping("/order")
    public ResponseEntity<PaymentResponse> createOrder(@RequestBody OrderRequest req,
                                                       @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req, user);
        PaymentResponse res = paymentService.createPaymentLink(order);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Order> orders = orderService.getUsersOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
