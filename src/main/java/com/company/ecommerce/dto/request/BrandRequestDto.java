package com.company.ecommerce.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrandRequestDto {
    Long id;
    String name;
    String description;
    List<ProductRequestDto> products;
}
