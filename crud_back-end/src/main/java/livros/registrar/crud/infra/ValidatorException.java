package livros.registrar.crud.infra;


public class ValidatorException extends RuntimeException {
    public ValidatorException(String s) {
        super(s);
    }
}
