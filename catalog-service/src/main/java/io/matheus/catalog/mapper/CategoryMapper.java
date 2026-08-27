package io.matheus.catalog.mapper;

import io.matheus.catalog.dto.CategoryResponseDTO;
import io.matheus.catalog.model.Category;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = CategoryMapper.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {

    CategoryResponseDTO toDto(Category entity);
}
