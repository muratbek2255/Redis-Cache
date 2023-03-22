package com.example.rediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final ProductRepository itemRepository;

    @Autowired
    public ProductService(ProductRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Cacheable(value = "itemCache")
    public Product getItemForId(String id) {
        return itemRepository.findById(Integer.valueOf(id))
                .orElseThrow(RuntimeException::new);
    }
}
