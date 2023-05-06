package com.company.ecommerce.service;

import com.company.ecommerce.dto.request.CartRequestDto;
import com.company.ecommerce.dto.response.CartResponseDto;
import com.company.ecommerce.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CartService {
    List<CartResponseDto> findAll();
    CartResponseDto findById(Long id);
    ResponseEntity<ResponseDto> insert(CartRequestDto cartRequestDto);
    ResponseEntity<ResponseDto> update(CartRequestDto cartRequestDto);
    ResponseEntity<ResponseDto> delete(Long id);
}
