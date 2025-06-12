package utez.edu.mx.sagg.models.role;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import utez.edu.mx.sagg.models.user.Users;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column(name = "role_name", nullable = false, unique = true)
    private String name;  // Cambiado de 'role' a 'name'

    @JsonIgnoreProperties(value = {"users"})
    @OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST)
    private List<Users> users;

    public Role(String name) {  // Cambiado el parámetro para coincidir
        this.name = name;
    }
}