package com.iipay.price.api.service;

import com.iipay.price.api.dto.PriceResponseDTO;
import com.iipay.price.api.model.Product;
import com.iipay.price.api.repository.ProductPriceRepository;
import com.iipay.price.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final ProductPriceRepository productPriceRepository;
    private final ProductRepository productRepository;

    public List<PriceResponseDTO> getProductPrices(String product, String country) {
        List<Product> products =  productRepository.findProductsByCountryAndNameOrDescription(product, country);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return products.stream().map(PriceResponseDTO::fromProduct).collect(Collectors.toList());
    }
}
