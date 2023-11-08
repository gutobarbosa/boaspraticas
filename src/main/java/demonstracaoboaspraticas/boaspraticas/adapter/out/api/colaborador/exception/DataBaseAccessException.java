package demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.exception;

public class DataBaseAccessException extends RuntimeException {

    public DataBaseAccessException(){
        super();
    }
    public DataBaseAccessException (String message, Throwable error){
        super(message,error);
    }
}
