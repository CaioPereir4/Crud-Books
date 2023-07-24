package livros.registrar.crud.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleError {
    @ExceptionHandler(ValidatorException.class)
    public ResponseEntity<String> tratarErroDeValidacao(ValidatorException exception) {
        var erros = exception.getLocalizedMessage();
        return ResponseEntity.badRequest().body(erros);

    }

}
