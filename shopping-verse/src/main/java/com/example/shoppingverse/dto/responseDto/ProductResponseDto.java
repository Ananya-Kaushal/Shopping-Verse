package com.example.shoppingverse.dto.responseDto;

import com.example.shoppingverse.Enum.ProductCategory;
import com.example.shoppingverse.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    String sellerName;

    String productName;

    int price;

    int availableQuantity;

    ProductCategory category;

    ProductStatus productStatus;

}
