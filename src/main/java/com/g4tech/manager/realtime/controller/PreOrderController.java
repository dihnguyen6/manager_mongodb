package com.g4tech.manager.realtime.controller;

import com.g4tech.manager.realtime.models.PreOrder;
import com.g4tech.manager.realtime.models.Product;
import com.g4tech.manager.realtime.repositories.PreOrderRepository;
import com.g4tech.manager.realtime.repositories.ProductRepository;
import com.mongodb.DBCollection;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/preoders")
public class PreOrderController {
    @Autowired
    private PreOrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<PreOrder> getAllPreOrders () {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PreOrder getPreOrderById (@PathVariable("id")ObjectId id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PreOrder createPreOrder(@PathVariable("productId") String productId, @Valid @RequestBody PreOrder preOrder) {
        PreOrder preOrd = new PreOrder();
        Product product = productRepository.findById(new ObjectId(productId));
        preOrd.setProduct(product);
        repository.save(preOrd);
        return preOrd;
    }
}
