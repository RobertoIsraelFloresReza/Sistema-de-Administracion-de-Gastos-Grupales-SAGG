package utez.edu.mx.sagg.controllers.person.dto;
import utez.edu.mx.sagg.models.person.Persons;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private Long idPerson;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String role;
    private boolean status;

    public Persons toEntity(){
        return new Persons(idPerson,name,lastname,email,phone,status) ;
    }
}
