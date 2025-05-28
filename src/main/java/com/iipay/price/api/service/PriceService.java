package com.iipay.price.api.service;

import com.iipay.price.api.repository.ProductPriceRepository;
import com.iipay.price.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final ProductPriceRepository productPriceRepository;
    private final ProductRepository productRepository;
}
