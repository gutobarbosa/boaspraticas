package demonstracaoboaspraticas.boaspraticas.core.ports.in;

import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;

public interface ConsultarColaboradorPort {
     Colaborador consultarNomeColaborador(String nomeColaborador);
     Colaborador consultarNomeColaboradorPeloID(Long id);
}
