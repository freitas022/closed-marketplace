package io.matheus.catalog.controller;

import io.matheus.catalog.dto.CategoryRequestDTO;
import io.matheus.catalog.dto.CategoryResponseDTO;
import io.matheus.catalog.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody @Valid CategoryRequestDTO req) {
        var category = categoryService.create(req);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.id()).toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }
}
