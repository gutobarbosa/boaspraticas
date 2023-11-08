package demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.cadastrarcolaborador;

import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.exception.DataBaseAccessException;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.mapper.MapperColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.ColaboradorRepository;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.entity.ColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.ports.out.CadastrarColaboradorPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class CadastrarColaboradorAdapter implements CadastrarColaboradorPort {
    private static final Logger logger = LoggerFactory.getLogger(CadastrarColaboradorAdapter.class);

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    MapperColaboradorEntity mapperColaboradorEntity;


    @Override
    public Colaborador cadastrarColaborador(Colaborador cadastrarColaborador) {
            Colaborador colaborador = null;
        try {
            logger.info("Iniciando processo de persistencia do dado");

            // Convertendo o model transitado no core para entidade para a acao dentro do banco de dados
            ColaboradorEntity modelToEntity = mapperColaboradorEntity.modelToEntity(cadastrarColaborador);

            //consistindo dados no banco de dados
            ColaboradorEntity colaboradorRegistrado = colaboradorRepository.save(modelToEntity);

            // convertendo para Model novamente para devolver o resultado da informacao
            colaborador = mapperColaboradorEntity.entityToModel(colaboradorRegistrado);

        }catch (Exception e){
            logger.error("Nao foi possivel concluir o cadastro do colaborador",e);
            throw new DataBaseAccessException("Erro ao inserir informacoes no banco de dados",e);
        }

        // Sucesso na criacao do usuario no banco
            logger.info("Cadastro realizado com sucesso",colaborador );

            return (colaborador);
    }
}
