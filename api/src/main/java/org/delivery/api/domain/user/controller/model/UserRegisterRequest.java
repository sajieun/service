package org.delivery.api.domain.user.controller.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String address;

    @NotNull
    private String password;

}
