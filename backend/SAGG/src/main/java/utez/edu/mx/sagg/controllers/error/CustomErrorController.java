package utez.edu.mx.sagg.controllers.error;

import utez.edu.mx.sagg.annotation.LogAuditoria;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    @GetMapping
    @LogAuditoria
    public String handleError() {
        return "error/error"; // Redirige a la vista personalizada
    }
}