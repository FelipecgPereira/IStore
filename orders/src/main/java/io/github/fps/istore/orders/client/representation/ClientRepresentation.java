package io.github.fps.istore.orders.client.representation;

public record ClientRepresentation(
        Long id,
        String name,
        String taxId,
        String street,
        String number,
        String neighborhood,
        String email,
        String phone
) {
}
