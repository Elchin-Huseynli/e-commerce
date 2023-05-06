package com.company.ecommerce.service;

import com.company.ecommerce.dto.request.CategoryRequestDto;
import com.company.ecommerce.dto.response.CategoryResponseDto;
import com.company.ecommerce.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> findAll();
    CategoryResponseDto findById(Long id);
    ResponseEntity<ResponseDto> insert(CategoryRequestDto categoryRequestDto);
    ResponseEntity<ResponseDto> update(CategoryRequestDto categoryRequestDto);
    ResponseEntity<ResponseDto> delete(Long id);
}
