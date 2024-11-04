package org.delivery.db.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;
import org.delivery.db.store.enums.StoreStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserEntity extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

//    @Column(length = 50, nullable = false)
//    @Enumerated(EnumType.STRING)
//    원래는 이거였는데 계속 타입 오류 남 밑에 해결

    @Column(columnDefinition = "varchar(50)", nullable = false) // 컬럼 정의를 명시적으로 지정하는 것
    @Enumerated(EnumType.STRING)
    private StoreStatus status;

    @Column(length = 150, nullable = false)
    private String address;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime lastLoginAt;
}
