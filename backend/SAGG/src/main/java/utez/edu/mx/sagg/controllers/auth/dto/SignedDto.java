package utez.edu.mx.sagg.controllers.auth.dto;

import utez.edu.mx.sagg.models.role.Role;
import utez.edu.mx.sagg.models.user.Users;
import lombok.Value;

@Value
public class SignedDto {
    String token;
    String tokenType;
    Users user;
    Role roles;
}
