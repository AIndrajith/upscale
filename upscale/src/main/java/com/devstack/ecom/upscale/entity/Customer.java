package com.devstack.ecom.upscale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customer")
public class Customer {
    @Id
    @Column(name = "property_id", nullable = false, length = 80)
    private String properetyId;

    @Column(name = "name", length = 45, nullable = false, unique = true)
    private String name;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "is_active", columnDefinition = "TINYINT")
    private boolean isActive;
}
