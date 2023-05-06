package com.company.ecommerce.service.impl;

import com.company.ecommerce.dto.request.CartRequestDto;
import com.company.ecommerce.dto.response.CartResponseDto;
import com.company.ecommerce.dto.response.ResponseDto;
import com.company.ecommerce.entity.Cart;
import com.company.ecommerce.exception.NotFoundException;
import com.company.ecommerce.repository.CartRepository;
import com.company.ecommerce.repository.ProductRepository;
import com.company.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CartResponseDto> findAll() {
        return cartRepository.findAll().stream()
                .map(cart -> modelMapper.map(cart, CartResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CartResponseDto findById(Long id) {
        return modelMapper.map(cartRepository.findById(id).orElseThrow(NotFoundException::new),
                CartResponseDto.class);
    }

    @Override
    public ResponseEntity<ResponseDto> insert(CartRequestDto cartRequestDto) {
        final Cart cart = modelMapper.map(cartRequestDto, Cart.class);
        cart.setProduct(productRepository.findById(cartRequestDto.getProductId())
                .orElseThrow(NotFoundException::new));
        cartRepository.save(cart);
        return ResponseEntity.ok(new ResponseDto("Created successfully!"));
    }

    @Override
    public ResponseEntity<ResponseDto> update(CartRequestDto cartRequestDto) {
        cartRepository.save(modelMapper.map(cartRequestDto, Cart.class));
        return ResponseEntity.ok(new ResponseDto("Updated successfully!"));
    }

    @Override
    public ResponseEntity<ResponseDto> delete(Long id) {
        cartRepository.deleteById(id);
        return ResponseEntity.ok(new ResponseDto("Delete successfully!"));
    }
}
