package demonstracaoboaspraticas.boaspraticas.core.services.exception;

public class ErroFaltaInformacaoException extends RuntimeException {
    public ErroFaltaInformacaoException(){
        super();
    }
    public ErroFaltaInformacaoException(String s, Throwable e) {
        super(s,e);
    }
}
