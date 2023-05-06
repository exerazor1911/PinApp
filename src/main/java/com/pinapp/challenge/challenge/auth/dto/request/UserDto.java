package com.pinapp.challenge.challenge.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    @Email(message = "El mail de nombre de usuario debe ser valido")
    private String username;

    @Size(min = 8, message = "La contraseña debe tener minimo 8 caracteres")
    private String password;

}
