package com.g4tech.manager.realtime.controller;

import com.g4tech.manager.realtime.models.Product;
import com.g4tech.manager.realtime.repositories.ProductRepository;
import com.g4tech.manager.realtime.utils.ZonedDateTimeReadConverter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    private ZonedDateTimeReadConverter time;

    // GET Method
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String id) {
        return repository.findOne(id);
    }*/

    // POST Method
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createProduct(@Valid @RequestBody Product product) {
        repository.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable ObjectId id, @PathVariable double preis, @RequestBody Product product) {
        Product prod = repository.findById(id);
        prod.setPreis(preis);
        repository.save(prod);
        return prod;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable ObjectId id) {
        Product prod = repository.findById(id);
        repository.delete(prod);
        return "deleted";
    }
}
