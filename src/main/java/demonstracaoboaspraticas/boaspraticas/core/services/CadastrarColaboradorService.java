package demonstracaoboaspraticas.boaspraticas.core.services;

import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.ports.out.CadastrarColaboradorPort;
import demonstracaoboaspraticas.boaspraticas.core.services.exception.ErroFaltaInformacaoException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class CadastrarColaboradorService implements demonstracaoboaspraticas.boaspraticas.core.ports.in.CadastrarColaboradorPort {

    private static final Logger logger = LoggerFactory.getLogger(DefinirSalarioColaboradorInternoService.class);

    @Autowired
    CadastrarColaboradorPort cadastrarColaboradorPortOut;

    @Autowired
    DefinirSalarioColaboradorInternoService definirSalarioColaboradorInternoService;

    @Autowired
    DefinirSalarioColaboradorExternoService definirSalarioColaboradorExternoService;


    @Override
    public Colaborador cadastrarColaborador(Colaborador cadastrarColaborador) {
        Colaborador cadastro = null;
        try{
            logger.info("Ajustando o salario e inserindo colaborador na base");
            //if ternario
            // Ajustando o valor do Salario do colaborador
            Colaborador colaborador = cadastrarColaborador.getTipoColaborador().equals("interno")
                    ? definirSalarioColaboradorInternoService.definirSalarioColaborador(cadastrarColaborador)
                    : definirSalarioColaboradorExternoService.definirSalarioColaborador(cadastrarColaborador);
            logger.info("Ajuste do salario do colaborador realizado com sucesso");

           cadastro = cadastrarColaboradorPortOut.cadastrarColaborador(cadastrarColaborador);

        }catch (NullPointerException e){
            logger.error("Erro na acao de cadastro do colaborador",e);
            // Este erro nao ocorrera pois tratamos o dado no DTO para que o campo nao venha vazio, mas isso seria um exemplo de tratativa caso um campo faltasse do payload e sua tratativa
            throw new ErroFaltaInformacaoException("Nao foi possivel calcular o salario",e);
        }
        logger.info("Insercao concluida com sucesso");
        return cadastro;
    }
}
