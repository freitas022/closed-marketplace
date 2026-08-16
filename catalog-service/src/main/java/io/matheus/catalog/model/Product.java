package io.matheus.catalog.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.Instant;

@Document(collection = "products")
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @MongoId
    @EqualsAndHashCode.Include
    private String id;
    private String name;

    @Indexed(unique = true)
    private String sku;

    @Field(name = "short_description")
    private String shortDescription;

    @Field(name = "long_description")
    private String longDescription;


    private BigDecimal price;

    @CreatedDate
    @Field(name = "created_at")
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    public Product(String name, String shortDescription, String longDescription, BigDecimal price) {
        this.name = name;
        this.sku = "P-" + Instant.now().getEpochSecond();
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.price = price;
    }
}
