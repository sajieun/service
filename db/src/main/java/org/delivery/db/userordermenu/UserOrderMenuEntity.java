package org.delivery.db.userordermenu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;
import org.delivery.db.userordermenu.enums.UserOrderMenuStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "user_order_menu")
public class UserOrderMenuEntity extends BaseEntity {

    @Column(nullable = false)
    private Long userOrderId;  // 1:n

    @Column(nullable = false)
    private Long storeMenuId;  // 1:n

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private UserOrderMenuStatus status;
}
