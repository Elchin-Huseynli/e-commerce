package com.company.ecommerce.dto.request;

import com.company.ecommerce.entity.Product;
import com.company.ecommerce.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartRequestDto {
    Long id;
    Integer count;
    Double totalAmount;
    User user;
    Long productId;
}
