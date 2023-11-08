package demonstracaoboaspraticas.boaspraticas.adapter.in.http.exception;

import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.exception.DataBaseAccessException;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.exception.UsuarioNaoEncontradoException;
import demonstracaoboaspraticas.boaspraticas.core.services.exception.ErroFaltaInformacaoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DataBaseAccessException.class)
    public ResponseEntity<Object> dataBaseAccessErrorException(DataBaseAccessException dataBaseAccessException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dataBaseAccessException.getMessage());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(ErroFaltaInformacaoException.class)
    public ResponseEntity<Object> erroCalculoSalarioException(ErroFaltaInformacaoException erroCalculoSalarioException){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erroCalculoSalarioException.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Object> usuarioNaoEncontradoException(UsuarioNaoEncontradoException usuarioNaoEncontradoException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuarioNaoEncontradoException.getMessage());
    }

}
