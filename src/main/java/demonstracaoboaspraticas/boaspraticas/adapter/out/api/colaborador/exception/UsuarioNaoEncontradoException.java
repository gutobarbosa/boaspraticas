package demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(){
        super();
    }
    public UsuarioNaoEncontradoException (String message, Throwable error){
        super(message,error);
    }
    public UsuarioNaoEncontradoException(String usuarioNaoEncontrado) {
        super(usuarioNaoEncontrado);
    }
}
