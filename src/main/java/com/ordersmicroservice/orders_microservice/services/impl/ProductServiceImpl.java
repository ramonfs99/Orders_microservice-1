package com.ordersmicroservice.orders_microservice.services.impl;

import com.ordersmicroservice.orders_microservice.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class ProductServiceImpl {
    public String baseUrl;
    public String productUri;
    public String stock2Uri;
    private final RestClient restClient;

    public ProductServiceImpl(RestClient restClient,
                              @Value("${catalog.api.base-url}") String baseUrl,
                              @Value("${catalog.api.product-uri}") String productUri,
                              @Value("${catalog.api.stock2-uri}") String stock2Uri) {
        this.baseUrl = baseUrl;
        this.productUri = productUri;
        this.stock2Uri = stock2Uri;
        this.restClient = restClient;
    }

    public ProductDto patchProductStock(Long productId, int quantity) {
        log.info("patchProductStock( productId:  {}, quantity: {} )",productId,quantity);
        return restClient.patch()
                .uri(baseUrl + stock2Uri, quantity,productId)
                .retrieve()
                .body(ProductDto.class);
    }

    public ProductDto getProductById(Long productId) {
        log.info("getProductById( productId:  {} )",productId);
        return restClient.get()
                .uri(baseUrl + productUri, productId)
                .retrieve()
                .body(ProductDto.class);
    }
}
