package io.matheus.catalog.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @MongoId
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    public static Category create(String name) {
        return Category.builder().name(name).build();
    }

    @Override
    public String toString() {
        return "Category={id=%s, name=%s}".formatted(id, name);
    }
}
