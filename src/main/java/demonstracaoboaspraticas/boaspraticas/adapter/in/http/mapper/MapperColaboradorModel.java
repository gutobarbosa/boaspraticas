package demonstracaoboaspraticas.boaspraticas.adapter.in.http.mapper;

import demonstracaoboaspraticas.boaspraticas.adapter.in.http.dto.ColaboradorDTO;
import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface MapperColaboradorModel {
    //Conversao de tipo de dados de acordo com a camada da aplicacao

    // Convertendo o dado de model para DTO para que seja o formato de retorno no controller para o usuario final
    ColaboradorDTO modelToDto (Colaborador colaborador);

    // Convertendo DTO para Model para que o dado que transita na camada do core seja o correto.
    Colaborador dtoToModel (ColaboradorDTO colaboradorDTO);

}
