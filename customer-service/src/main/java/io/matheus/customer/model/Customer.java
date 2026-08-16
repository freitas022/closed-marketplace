package io.matheus.customer.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Table(name = "tb_customers", schema = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "firstname", nullable = false, length = 90)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 90)
    private String lastname;

    @Column(nullable = false, unique = true, length = 14)
    private String document;

    @Column(nullable = false, length = 30)
    private String phone;

    @Column(nullable = false, unique = true, length = 120)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    public String fullName() {
        return String.format("%s %s", this.firstname, this.lastname);
    }

    @Override
    public String toString() {
        return "Customer{name='%s', document='%s', email='%s', createdAt='%s'}"
                .formatted(fullName(), document, email, createdAt.truncatedTo(ChronoUnit.SECONDS));
    }
}
