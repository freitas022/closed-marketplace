package io.matheus.catalog.config;

import io.matheus.catalog.model.Category;
import io.matheus.catalog.model.CategoryRepository;
import io.matheus.catalog.model.Product;
import io.matheus.catalog.model.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CatalogSeedData implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() > 0) {
            return;
        }

        var p1 = new Product("Notebook Gamer", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "Praesent molestie accumsan leo, ut porttitor ante pharetra sed. Fusce pellentesque eros " +
                        "neque, ut suscipit augue sagittis id. Maecenas facilisis interdum massa vitae elementum. " +
                        "Quisque congue metus vitae interdum viverra. Curabitur feugiat ligula semper urna lobortis, at " +
                        "pellentesque elit venenatis. Donec a euismod velit, vel eleifend nulla. Nunc vulputate malesuada " +
                        "libero. Duis malesuada turpis a urna maximus vehicula. Donec at tortor ante. Ut commodo mi est, " +
                        "vel semper est lobortis nec. Cras scelerisque congue fermentum. Curabitur fermentum placerat turpis," +
                        " a feugiat ligula faucibus id. Nullam elementum elit sed urna egestas, eu dapibus nisi consequat." +
                        " Aenean dictum dolor eget erat dapibus posuere.",
                new BigDecimal("9500.99"));

        var c1 = new Category(null, "Eletrônicos");
        productRepository.save(p1);
        categoryRepository.save(c1);
    }
}
