package utez.edu.mx.sagg.config;

import utez.edu.mx.sagg.models.person.Persons;
import utez.edu.mx.sagg.models.person.PersonsRepository;
import utez.edu.mx.sagg.models.role.Role;
import utez.edu.mx.sagg.models.role.RoleRepository;
import utez.edu.mx.sagg.models.user.Users;
import utez.edu.mx.sagg.models.user.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InitialDataService {

    private final RoleRepository roleRepository;
    private final PersonsRepository personsRepository;
    private final UsersRepository usersRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public void initializeRolesAndUsers() {
        Role adminRole = getOrSaveRole(new Role("ADMIN_GENERAL"));
        Role workerRole = getOrSaveRole(new Role("ADMIN_GRUPAL"));
        Role clientRole = getOrSaveRole(new Role("USUARIO_REGULAR"));

        createUserWithRole("Nelida", "Baron Perez", "nelidabaron@utez.edu.mx", "admingeneral", adminRole);
        createUserWithRole("Andrea", "Aquino Flores", "20233tn183@utez.edu.mx", "admingrupal", workerRole);
        createUserWithRole("Israel", "Flores Reza", "20223TN016@utez.edu.mx", "usuarioregular", clientRole);
    }

    private void createUserWithRole(String name, String lastName, String email, String password, Role role) {
        Persons person = getOrSavePersons(new Persons(name, lastName, email, "7773438000", true));
        Users user = getOrSaveUsers(new Users(email, encoder.encode(password), true, person));
        user.setRole(role);
        usersRepository.save(user);
    }

    private Role getOrSaveRole(Role role) {
        return roleRepository.findByName(role.getName())
                .orElseGet(() -> roleRepository.saveAndFlush(role));
    }

    private Persons getOrSavePersons(Persons person) {
        return personsRepository.findByEmail(person.getEmail())
                .orElseGet(() -> personsRepository.saveAndFlush(person));
    }

    private Users getOrSaveUsers(Users user) {
        Optional<Users> foundUser = usersRepository.findByEmail(user.getEmail());
        if (foundUser.isPresent()) return foundUser.get();

        if (user.getPersons() != null && user.getPersons().getIdPerson() == null) {
            user.setPersons(getOrSavePersons(user.getPersons()));
        }

        return usersRepository.saveAndFlush(user);
    }
}
