package io.matheus.customer;

import io.matheus.customer.dto.CustomerRequestDTO;
import io.matheus.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@ActiveProfiles("test")
@Import(TestcontainersConfiguration.class)
@SpringBootTest
@Transactional
class CustomerApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldCreateCustomer() {
        var request = new CustomerRequestDTO(
                "Zaeion",
                "Felapi",
                "11102058050",
                "13912345678",
                "zaeion@outlook.com"
        );

        var response = customerService.create(request);

        assertThat(response).satisfies(r -> {
            assertThat(r.id()).isNotNull();
            assertThat(r.name()).isEqualTo("Zaeion Felapi");
            assertThat(r.document()).isEqualTo("11102058050");
            assertThat(r.phone()).isEqualTo("13912345678");
            assertThat(r.email()).isEqualTo("zaeion@outlook.com");
            assertThat(r.createdAt()).isNotNull();
        });
    }

    @Test
    void shouldThrowExceptionWhenDocumentAlreadyExists() {
        var request = new CustomerRequestDTO(
                "Mike",
                "House",
                "98645087090",
                "22987654321",
                "mike.house9@gmail.com"
        );

        customerService.create(request);

        var duplicateRequest = new CustomerRequestDTO(
                "Mike",
                "House",
                "98645087090",
                "22999261310",
                "mike.house@gmail.com"
        );

        assertThatThrownBy(() -> customerService.create(duplicateRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("documento");
    }

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists() {
        var request = new CustomerRequestDTO(
                "Matheus",
                "Freitas",
                "40149736037",
                "21986523851",
                "matheus@outlook.com"
        );

        customerService.create(request);

        var duplicateRequest = new CustomerRequestDTO(
                "Outro Nome",
                "Outro Sobrenome",
                "15484825793",
                "22999261310",
                "matheus@outlook.com"
        );

        assertThatThrownBy(() -> customerService.create(duplicateRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("email");
    }
}
