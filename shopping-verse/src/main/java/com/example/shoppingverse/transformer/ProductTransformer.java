package com.example.shoppingverse.transformer;

import com.example.shoppingverse.Enum.ProductStatus;
import com.example.shoppingverse.dto.requestDto.ProductRequestDto;
import com.example.shoppingverse.dto.responseDto.ProductResponseDto;
import com.example.shoppingverse.model.Product;

public class ProductTransformer {

    public  static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto)
    {
        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .availableQuantity(productRequestDto.getAvailableQuantity())
                .category(productRequestDto.getCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product)
    {
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .availableQuantity(product.getAvailableQuantity())
                .category(product.getCategory())
                .productStatus(product.getProductStatus())
                .sellerName(product.getSeller().getName())
                .build();
    }
}
