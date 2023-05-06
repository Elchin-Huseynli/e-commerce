package com.company.ecommerce.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponseDto {
    ProductResponseDto product;
    Integer count;
    Double totalAmount;
    UserResponseDto user;
}
