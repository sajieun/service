package org.delivery.api.domain.storemenu.controller.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreMenuRegisterRequest {

    @NotBlank
    private Long storeId;

    @NotBlank
    private String name;

    @NotBlank
    private BigDecimal amount;

    @NotBlank
    private String thumbnailUrl;
}
