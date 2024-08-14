package org.delivery.db.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "store")
public class StoreEntity extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(length = 45, nullable = false)
    private String category;

    private double star;

    @Column(length = 200, nullable = false)
    private String thumbnail_url;

    @Column(precision = 11, scale = 4,nullable = false)
    private BigDecimal minimumAmount;

    @Column(precision = 11, scale = 4,nullable = false)
    private BigDecimal minimumDeliveryAmount;

    @Column(length = 20)
    private String phoneNumber;

}
