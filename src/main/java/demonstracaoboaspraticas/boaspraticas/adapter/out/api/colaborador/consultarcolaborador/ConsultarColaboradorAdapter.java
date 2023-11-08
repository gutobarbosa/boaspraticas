package demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.consultarcolaborador;

import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.exception.DataBaseAccessException;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.exception.UsuarioNaoEncontradoException;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.mapper.MapperColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.ColaboradorRepository;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.entity.ColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.ports.out.ConsultarColaboradorPort;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsultarColaboradorAdapter implements ConsultarColaboradorPort {
    private static final Logger logger = LoggerFactory.getLogger(ConsultarColaboradorAdapter.class);

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    MapperColaboradorEntity mapperColaboradorEntity;

    @Override
    public Colaborador consultarNomeColaborador(String nomeColaborador) {
        Colaborador colaborador = null;
        try {
            logger.info("Iniciando processo de consulta do dado");
            //buscando os dados no banco de dados
            ColaboradorEntity colaboradorEntity = (colaboradorRepository.findByNomeColaborador(nomeColaborador));

            if(colaboradorEntity == null){
                throw new UsuarioNaoEncontradoException("Usuario nao encontrado");
            }

            // convertendo para Model o resultado da busca no banco de dados para devolver a informacao
            colaborador = mapperColaboradorEntity.entityToModel(colaboradorEntity);


        } catch (DataBaseAccessException e) {
            logger.error("Erro ao acessar o banco de dados",e.getMessage());
            throw new DataBaseAccessException("Erro ao acessar o banco de dados",e);
        }

        logger.info("Consulta realizada com sucesso",colaborador );
        return colaborador;
    }

    @Override
    public Colaborador consultarNomeColaboradorPeloID(Long id) {

        Colaborador colaboradorId = null;
        try {
            logger.info("Iniciando processo de consulta do dado");

            //buscando os dados no banco de dados
           ColaboradorEntity colaboradorEntity = (colaboradorRepository.findByidColaborador(id));
           if(colaboradorEntity == null){
               throw new UsuarioNaoEncontradoException("Usuario nao encontrado");
           }

            // convertendo para Model o resultado da busca no banco de dados para devolver a informacao
            colaboradorId = mapperColaboradorEntity.entityToModel(colaboradorEntity);


        } catch (DataBaseAccessException e) {
            logger.error("Erro ao acessar o banco de dados", e.getMessage());
            throw new DataBaseAccessException("Erro ao acessar o banco de dados",e);
        }

        logger.info("Consulta realizada com sucesso",colaboradorId );
        return colaboradorId;
    }
}
