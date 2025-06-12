package utez.edu.mx.sagg.services.auditoria;

import utez.edu.mx.sagg.models.auditoria.AuditoriaLog;
import utez.edu.mx.sagg.models.auditoria.AuditoriaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
public class AuditoriaService {
    private final AuditoriaRepository repository;

    public AuditoriaService(AuditoriaRepository repository) {
        this.repository = repository;
    }

    public void registrarAccion(String accion, String modulo, String detalles, HttpServletRequest request) {
        String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        String ip = request.getRemoteAddr();

        AuditoriaLog log = new AuditoriaLog();
        log.setUsuario(usuario);
        log.setAccion(accion);
        log.setModulo(modulo);
        log.setDetalles(detalles);
        log.setIp(ip);

        repository.save(log);
    }
}