package io.matheus.catalog;

import org.springframework.boot.SpringApplication;

public class TestCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(CatalogApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
