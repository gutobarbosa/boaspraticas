package demonstracaoboaspraticas.boaspraticas.core.services;

import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.ports.in.DefinirSalarioColaboradorInternoPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@Slf4j
@Service
public class DefinirSalarioColaboradorInternoService implements DefinirSalarioColaboradorInternoPort {
    private static final Logger logger = LoggerFactory.getLogger(DefinirSalarioColaboradorInternoService.class);

    @Override
    public Colaborador definirSalarioColaborador(Colaborador salarioColaborador) {

            logger.info("Aplicando regra de calculo salarial");
            BigDecimal salario = salarioColaborador.getSalarioColaborador();
            BigDecimal multiplicacao = new BigDecimal(5) ;
            BigDecimal resultado = salario.multiply(multiplicacao);

            salarioColaborador.setSalarioColaborador(resultado);

            logger.info("Realizado a correcao salarial do colaborador");

            return salarioColaborador;
    }
}
