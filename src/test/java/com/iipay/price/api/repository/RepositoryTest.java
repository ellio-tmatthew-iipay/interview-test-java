package com.iipay.price.api.repository;

import com.iipay.price.api.model.Product;
import com.iipay.price.api.model.ProductPrice;
import com.iipay.price.api.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRepositoriesReturnNonNullResults() {
        // Test ProductRepository
        List<Product> products = productRepository.findAll();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println("[DEBUG_LOG] Found " + products.size() + " products");
        for (int i = 0; i < products.size(); i++) {
            assertNotNull(products.get(i), "Product at index " + i + " is null");
            System.out.println("[DEBUG_LOG] Product " + i + ": " + products.get(i));
        }

        // Test ProductPriceRepository
        List<ProductPrice> prices = productPriceRepository.findAll();
        assertNotNull(prices);
        assertFalse(prices.isEmpty());
        System.out.println("[DEBUG_LOG] Found " + prices.size() + " product prices");
        for (int i = 0; i < prices.size(); i++) {
            assertNotNull(prices.get(i), "ProductPrice at index " + i + " is null");
            System.out.println("[DEBUG_LOG] ProductPrice " + i + ": " + prices.get(i));
        }

        // Test UserRepository
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        System.out.println("[DEBUG_LOG] Found " + users.size() + " users");
        for (int i = 0; i < users.size(); i++) {
            assertNotNull(users.get(i), "User at index " + i + " is null");
            System.out.println("[DEBUG_LOG] User " + i + ": " + users.get(i));
        }
    }
}
