package utez.edu.mx.sagg.controllers.person;
import utez.edu.mx.sagg.annotation.LogAuditoria;
import utez.edu.mx.sagg.config.ApiResponse;
import utez.edu.mx.sagg.controllers.person.dto.PersonDto;
import utez.edu.mx.sagg.services.person.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    @LogAuditoria
    public ResponseEntity<ApiResponse> getAll(){
        return personService.getAll();
    }
    @GetMapping("/{id}")
    @LogAuditoria
    public ResponseEntity<ApiResponse> getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }
    @PostMapping("/")
    @LogAuditoria
    public ResponseEntity<ApiResponse> savePerson(@RequestBody PersonDto person){
        return personService.savePerson(person.toEntity());
    }
    @PutMapping("/")
    @LogAuditoria
    public ResponseEntity<ApiResponse> updatePerson(@RequestBody PersonDto person){
        return personService.updatePerson(person.toEntity());
    }

    @DeleteMapping("/{id}")
    @LogAuditoria
    public ResponseEntity<ApiResponse> deletePersonById(@PathVariable Long id){
        return personService.deletePersonById(id);
    }

    @GetMapping("/email/{email}")
    @LogAuditoria
    public ResponseEntity<ApiResponse> getPersonByEmail(@PathVariable String email){
        return personService.getPersonByEmail(email);
    }
}
