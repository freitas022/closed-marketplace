package io.matheus.catalog.service;

import io.matheus.catalog.dto.CategoryRequestDTO;
import io.matheus.catalog.dto.CategoryResponseDTO;
import io.matheus.catalog.mapper.CategoryMapper;
import io.matheus.catalog.model.Category;
import io.matheus.catalog.model.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponseDTO create(CategoryRequestDTO req) {
        var name = req.name();

        Category data = Category.builder().name(name).build();

        var category = categoryRepository.save(data);

        var categoryDTO = categoryMapper.toDto(category);

        log.info("Novo registro: {}", categoryDTO);

        return categoryDTO;
    }

    public CategoryResponseDTO findById(String id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Resource not found!"));
    }
}
