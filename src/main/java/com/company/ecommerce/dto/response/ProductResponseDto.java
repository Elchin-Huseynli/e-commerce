package com.company.ecommerce.dto.response;

import com.company.ecommerce.entity.ProductDetails;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {
    String name;
    String description;
    Double amount;
    Integer remainCount;
    ProductDetails productDetails;
}
