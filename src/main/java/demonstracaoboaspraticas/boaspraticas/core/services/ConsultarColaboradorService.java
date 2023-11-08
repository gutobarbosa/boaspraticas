package demonstracaoboaspraticas.boaspraticas.core.services;

import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.ports.out.ConsultarColaboradorPort;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsultarColaboradorService implements demonstracaoboaspraticas.boaspraticas.core.ports.in.ConsultarColaboradorPort {
    private static final Logger logger = LoggerFactory.getLogger(DefinirSalarioColaboradorInternoService.class);

    @Autowired
    ConsultarColaboradorPort consultarColaboradorPortOut;

    @Override
    public Colaborador consultarNomeColaborador(String nomeColaborador) {
        Colaborador consultaNome = null;

        logger.info("Realizando consulta do colaborador na base de dados");
        consultaNome = consultarColaboradorPortOut.consultarNomeColaborador(nomeColaborador);

        logger.info("Consulta realizada com sucesso");
        return consultaNome;
    }

    @Override
    public Colaborador consultarNomeColaboradorPeloID(Long id) {
        Colaborador consultaId = null;

        logger.info("Realizando consulta do colaborador na base de dados");
        consultaId = consultarColaboradorPortOut.consultarNomeColaboradorPeloID(id);


        logger.info("Consulta realizada com sucesso");
        return consultaId;
    }
}
