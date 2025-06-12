package utez.edu.mx.sagg.services.bitacora;


import utez.edu.mx.sagg.config.ApiResponse;
import utez.edu.mx.sagg.models.bitacora.BitacoraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BitacoraService {
    private final BitacoraRepository bitacoraRepository;

    public BitacoraService(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }

    @Transactional
    public ResponseEntity<ApiResponse> getAll(){
        return new ResponseEntity<>(new ApiResponse(
                bitacoraRepository.findAll(), HttpStatus.OK
        ), HttpStatus.OK);
    }
}
