package com.company.ecommerce.dto.request;

import com.company.ecommerce.entity.ProductDetails;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {
    Long id;
    String name;
    String description;
    Double amount;
    Integer remainCount;
    ProductDetails productDetails;
}
