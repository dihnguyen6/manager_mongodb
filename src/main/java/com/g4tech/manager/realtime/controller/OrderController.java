package com.g4tech.manager.realtime.controller;

import com.g4tech.manager.realtime.models.Order;
import com.g4tech.manager.realtime.repositories.OrderRepository;
import com.g4tech.manager.realtime.utils.ZonedDateTimeReadConverter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;
    private ZonedDateTimeReadConverter time;

    //GET Method
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable ObjectId id) {
        return repository.findById(id);
    }

    //POST method
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createOrder(@Valid @RequestBody Order order) {
        order.setOrderTime(time.convert(Calendar.getInstance().getTime()));
        repository.save(order);
    }

    //PUT method
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Order updateOrder(@PathVariable ObjectId id, @Valid @RequestBody Order order) {
        Order ord = repository.findById(id);
        if (order.getTable() != null) {
            ord.setTable(order.getTable());
        }
        if (order.getQuantity() != null) {
            ord.setQuantity(order.getQuantity());
        }
        ord.setStatus(order.isStatus());
        ord.setOrderTime(time.convert(Calendar.getInstance().getTime()));
        repository.save(ord);
        return ord;
    }
}
