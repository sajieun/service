package org.delivery.db.account;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {
}
