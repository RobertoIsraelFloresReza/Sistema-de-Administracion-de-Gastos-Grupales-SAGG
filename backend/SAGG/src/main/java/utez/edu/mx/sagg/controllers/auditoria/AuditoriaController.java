package utez.edu.mx.sagg.controllers.auditoria;

import utez.edu.mx.sagg.models.auditoria.AuditoriaLog;
import utez.edu.mx.sagg.models.auditoria.AuditoriaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
@CrossOrigin(origins = {"*"})
public class AuditoriaController {
    private AuditoriaRepository repository;

    @GetMapping
    public List<AuditoriaLog> obtenerLogs() {
        return repository.findAll();
    }

}
