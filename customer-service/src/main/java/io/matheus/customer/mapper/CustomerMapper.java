package io.matheus.customer.mapper;

import io.matheus.customer.dto.CustomerResponseDTO;
import io.matheus.customer.dto.CustomerRequestDTO;
import io.matheus.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toModel(CustomerRequestDTO dto);

    @Mapping(target = "name", expression = "java(entity.fullName())")
    CustomerResponseDTO toDto(Customer entity);
}
