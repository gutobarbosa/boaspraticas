package demonstracaoboaspraticas.boaspraticas.core.ports.out;

import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;

public interface ConsultarColaboradorPort {
     Colaborador consultarNomeColaborador(String nomeColaborador);
     Colaborador consultarNomeColaboradorPeloID(Long id);

}
