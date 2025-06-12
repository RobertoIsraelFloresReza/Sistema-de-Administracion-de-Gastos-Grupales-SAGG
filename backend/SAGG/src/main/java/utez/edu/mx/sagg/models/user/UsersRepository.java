package utez.edu.mx.sagg.models.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long>{
    @Override
    Optional<Users> findById(Long idUser);
    Optional<Users> findByEmail(String email);
}
