package com.company.ecommerce.controller;

import com.company.ecommerce.dto.request.CartRequestDto;
import com.company.ecommerce.dto.response.CartResponseDto;
import com.company.ecommerce.dto.response.ResponseDto;
import com.company.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
@Slf4j
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<CartResponseDto> findAll() {
        log.info("GET - /carts -> request none");
        List<CartResponseDto> response = cartService.findAll();
        log.info("GET - /carts - response -> {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public CartResponseDto findById(@PathVariable Long id) {
        log.info("GET - /cart/{} -> request", id);
        CartResponseDto response = cartService.findById(id);
        log.info("GET - /cart/{} - response -> {}", id, response);
        return response;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> insert(@RequestBody CartRequestDto cartRequestDto) {
        log.info("POST - /cart - request -> {}", cartRequestDto);
        ResponseEntity<ResponseDto> request = cartService.insert(cartRequestDto);
        log.info("POST - /cart -> response none");
        return request;

    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody CartRequestDto cartRequestDto) {
        log.info("PUT - /cart - request -> {}", cartRequestDto);
        ResponseEntity<ResponseDto> request = cartService.update(cartRequestDto);
        log.info("PUT - /cart -> response none");
        return request;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        log.info("DELETE - /cart/{} -> request", id);
        ResponseEntity<ResponseDto> request = cartService.delete(id);
        log.info("DELETE - /cart -> response none");
        return request;
    }
}
