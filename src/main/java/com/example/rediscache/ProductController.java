package com.example.rediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    private final ProductService itemService;

    @Autowired
    public ProductController(ProductService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item/{id}")
    public Product getItemById(@PathVariable String id) {
        return itemService.getItemForId(id);
    }
}
