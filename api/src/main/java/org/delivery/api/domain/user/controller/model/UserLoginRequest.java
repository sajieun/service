package org.delivery.api.domain.user.controller.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

    @NotNull
    private String email;

    @NotNull
    private String password;

}
