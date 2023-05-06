package com.company.ecommerce.service.impl;

import com.company.ecommerce.dto.request.CategoryRequestDto;
import com.company.ecommerce.dto.response.CategoryResponseDto;
import com.company.ecommerce.dto.response.ResponseDto;
import com.company.ecommerce.entity.Category;
import com.company.ecommerce.exception.NotFoundException;
import com.company.ecommerce.repository.CategoryRepository;
import com.company.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryResponseDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto findById(Long id) {
        return modelMapper.map(categoryRepository.findById(id).orElseThrow(NotFoundException::new),
                CategoryResponseDto.class);
    }

    @Override
    public ResponseEntity<ResponseDto> insert(CategoryRequestDto categoryRequestDto) {
        categoryRepository.save(modelMapper.map(categoryRequestDto, Category.class));
        return ResponseEntity.ok(new ResponseDto("Created successfully!"));
    }

    @Override
    public ResponseEntity<ResponseDto> update(CategoryRequestDto categoryRequestDto) {
        categoryRepository.save(modelMapper.map(categoryRequestDto, Category.class));
        return ResponseEntity.ok(new ResponseDto("Updated successfully!"));
    }

    @Override
    public ResponseEntity<ResponseDto> delete(Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.ok(new ResponseDto("Delete successfully!"));
    }
}
