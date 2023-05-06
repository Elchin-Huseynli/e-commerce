package com.company.ecommerce.controller;

import com.company.ecommerce.dto.request.CategoryRequestDto;
import com.company.ecommerce.dto.response.CategoryResponseDto;
import com.company.ecommerce.dto.response.ResponseDto;
import com.company.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> findAll() {
        log.info("GET - /categories -> request none");
        List<CategoryResponseDto> response = categoryService.findAll();
        log.info("GET - /categories - response -> {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public CategoryResponseDto findById(@PathVariable Long id) {
        log.info("GET - /category/{} -> request", id);
        CategoryResponseDto response = categoryService.findById(id);
        log.info("GET - /category/{} - response -> {}", id, response);
        return response;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> insert(@RequestBody CategoryRequestDto categoryRequestDto) {
        log.info("POST - /category - request -> {}", categoryRequestDto);
        ResponseEntity<ResponseDto> request = categoryService.insert(categoryRequestDto);
        log.info("POST - /category -> response none");
        return request;

    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody CategoryRequestDto categoryRequestDto) {
        log.info("PUT - /category - request -> {}", categoryRequestDto);
        ResponseEntity<ResponseDto> request = categoryService.update(categoryRequestDto);
        log.info("PUT - /category -> response none");
        return request;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        log.info("DELETE - /category/{} -> request", id);
        ResponseEntity<ResponseDto> request = categoryService.delete(id);
        log.info("DELETE - /category -> response none");
        return request;
    }
}
