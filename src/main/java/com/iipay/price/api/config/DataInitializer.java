package com.iipay.price.api.config;

import com.iipay.price.api.model.Product;
import com.iipay.price.api.model.ProductPrice;
import com.iipay.price.api.model.User;
import com.iipay.price.api.repository.ProductPriceRepository;
import com.iipay.price.api.repository.ProductRepository;
import com.iipay.price.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductPriceRepository productPriceRepository;

    @Override
    public void run(String... args) {
        // Create users
        User regularUser = new User(null, "regular_user", "regular123", User.UserType.REGULAR);
        User managerUser = new User(null, "manager_user", "manager123", User.UserType.MANAGER);
        userRepository.saveAll(Arrays.asList(regularUser, managerUser));

        // Create products
        Product laptop = new Product(null, "Laptop", "High-performance laptop");
        Product smartphone = new Product(null, "Smartphone", "Latest smartphone model");
        Product tablet = new Product(null, "Tablet", "Portable tablet");
        productRepository.saveAll(Arrays.asList(laptop, smartphone, tablet));

        // Create product prices for different countries
        List<ProductPrice> prices = Arrays.asList(
                // Laptop prices
                new ProductPrice(null, laptop, "US", new BigDecimal("999.99"), new BigDecimal("899.99")),
                new ProductPrice(null, laptop, "UK", new BigDecimal("899.99"), new BigDecimal("799.99")),
                new ProductPrice(null, laptop, "EU", new BigDecimal("949.99"), new BigDecimal("849.99")),

                // Smartphone prices
                new ProductPrice(null, smartphone, "US", new BigDecimal("699.99"), new BigDecimal("649.99")),
                new ProductPrice(null, smartphone, "UK", new BigDecimal("649.99"), new BigDecimal("599.99")),
                new ProductPrice(null, smartphone, "EU", new BigDecimal("679.99"), new BigDecimal("629.99")),

                // Tablet prices
                new ProductPrice(null, tablet, "US", new BigDecimal("499.99"), new BigDecimal("449.99")),
                new ProductPrice(null, tablet, "UK", new BigDecimal("459.99"), new BigDecimal("409.99")),
                new ProductPrice(null, tablet, "EU", new BigDecimal("479.99"), new BigDecimal("429.99"))
        );
        productPriceRepository.saveAll(prices);

        System.out.println("Database initialized with sample data");
    }
}