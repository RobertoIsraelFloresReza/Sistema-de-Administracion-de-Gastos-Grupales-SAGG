package utez.edu.mx.sagg.controllers.bitacora;

import utez.edu.mx.sagg.annotation.LogAuditoria;
import utez.edu.mx.sagg.config.ApiResponse;
import utez.edu.mx.sagg.services.bitacora.BitacoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bitacora")
@CrossOrigin(origins = {"*"})
public class BitacoraController {

    private final BitacoraService bitacoraService;

    public BitacoraController(BitacoraService bitacoraService) {
        this.bitacoraService = bitacoraService;
    }

    @GetMapping("/")
    @LogAuditoria
    public ResponseEntity<ApiResponse> getAll() {
        return bitacoraService.getAll();
    }


}
