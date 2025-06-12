package utez.edu.mx.sagg.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAuditoria {  // ¡Cambiado de LogTransaccion a LogAuditoria!
}