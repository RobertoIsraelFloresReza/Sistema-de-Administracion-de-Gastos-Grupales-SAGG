package utez.edu.mx.sagg.controllers.users.dto;

import utez.edu.mx.sagg.models.person.Persons;
import utez.edu.mx.sagg.models.role.Role;
import utez.edu.mx.sagg.models.user.Users;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Long idUser;
    private String email;
    private String password;
    private Boolean status;
    private Role role;
    private Persons persons;
    private Long ventanillaId;

    public Users toEntity() {
        Users user = new Users();
        user.setIdUser(idUser);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatus(status);

        if (role != null) {
            user.setRole(role);
        }
        if (persons != null) {
            user.setPersons(persons);
        }

        return user;
    }


}
