package com.iipay.price.api.controller;

import com.iipay.price.api.dto.PriceResponseDTO;
import com.iipay.price.api.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping
    public List<PriceResponseDTO> getProductPrices(String product, String country) {
        return priceService.getProductPrices(product, country);
    }
}