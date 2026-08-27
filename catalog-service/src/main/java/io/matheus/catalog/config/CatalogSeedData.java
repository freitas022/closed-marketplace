package io.matheus.catalog.config;

import io.matheus.catalog.model.Category;
import io.matheus.catalog.model.CategoryRepository;
import io.matheus.catalog.model.Product;
import io.matheus.catalog.model.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CatalogSeedData implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() > 0) {
            log.info("Já existem registros.");
            return;
        }
        var products = new ArrayList<Product>();
        for (int i = 1; i < 51; i++) {
            var product = Product.builder()
                    .name("Notebook Gamer %d".formatted(i))
                    .sku("P-%04d".formatted(i))
                    .shortDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                    .longDescription("Praesent molestie accumsan leo, ut porttitor ante pharetra sed. Fusce pellentesque eros " +
                            "neque, ut suscipit augue sagittis id. Maecenas facilisis interdum massa vitae elementum. " +
                            "Quisque congue metus vitae interdum viverra. Curabitur feugiat ligula semper urna lobortis, at " +
                            "pellentesque elit venenatis. Donec a euismod velit, vel eleifend nulla. Nunc vulputate malesuada " +
                            "libero. Duis malesuada turpis a urna maximus vehicula. Donec at tortor ante. Ut commodo mi est, " +
                            "vel semper est lobortis nec. Cras scelerisque congue fermentum. Curabitur fermentum placerat turpis," +
                            " a feugiat ligula faucibus id. Nullam elementum elit sed urna egestas, eu dapibus nisi consequat." +
                            " Aenean dictum dolor eget erat dapibus posuere.")
                    .price(new BigDecimal("%d95.99".formatted(i)))
                    .build();

            products.add(product);
        }

        log.info("{} registros inseridos.", products.stream().count());

        var c1 = Category.create("Eletrônicos");
        var c2 = Category.create("Smartphones");
        var c3 = Category.create("Laptops");

        productRepository.saveAll(products);
        categoryRepository.saveAll(List.of(c1, c2, c3));
    }
}
