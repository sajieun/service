package org.delivery.storeadmin.domain.storeuser.controller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.storeuser.enums.StoreUserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreUserRegisterRequest {

    @NotBlank
    private String storeName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private StoreUserRole role;
}
