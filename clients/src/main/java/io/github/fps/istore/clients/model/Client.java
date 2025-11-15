package io.github.fps.istore.clients.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "tax_id", length = 11, nullable = false, columnDefinition = "char(11)")
    private String taxId;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "number", length = 10)
    private String number;

    @Column(name = "neighborhood", length = 100)
    private String neighborhood;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;
}
