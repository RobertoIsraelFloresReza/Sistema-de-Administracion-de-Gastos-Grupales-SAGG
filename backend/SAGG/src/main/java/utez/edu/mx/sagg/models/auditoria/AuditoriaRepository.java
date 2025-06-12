package utez.edu.mx.sagg.models.auditoria;

import utez.edu.mx.sagg.models.auditoria.AuditoriaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaRepository extends JpaRepository<AuditoriaLog, Long> {
}