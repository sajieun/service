package org.delivery.db.store;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

import org.delivery.db.store.enums.StoreCategory;
import org.delivery.db.store.enums.StoreStatus;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder // 자식 클래스 간의 필드와 메서드를 공유할 때
@Entity
@Table(name = "store")
public class StoreEntity extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING) // 문자로 들어갈 수 있도록
    private StoreStatus status;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING) // 문자로 들어갈 수 있도록
    private StoreCategory category;

    private double star;

    @Column(length = 300, nullable = false)
    private String thumbnailUrl;

    @Column(precision = 11, scale = 4,nullable = false)
    private BigDecimal minimumAmount;

    @Column(precision = 11, scale = 4,nullable = false)
    private BigDecimal minimumDeliveryAmount;

    @Column(length = 20)
    private String phoneNumber;

}
