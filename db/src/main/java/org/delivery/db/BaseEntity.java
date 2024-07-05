package org.delivery.db;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
@MappedSuperclass
@Data
@SuperBuilder
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
