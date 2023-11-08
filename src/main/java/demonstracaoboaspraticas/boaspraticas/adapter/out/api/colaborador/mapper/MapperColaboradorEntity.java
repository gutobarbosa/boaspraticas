package demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.mapper;

import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.entity.ColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Mapper(componentModel = "spring")
@Service
public interface MapperColaboradorEntity {
    //Conversao de tipo de dados de acordo com a camada da aplicacao

    // Convertendo o dado de entidade para model pois model e o tipo de dado que deve transitar dentro do core
    Colaborador entityToModel(ColaboradorEntity colaboradorEntity);

    // Convertendo o dado de model para entidade para realizar a comunicacao com o banco de dados na camada do adapter
    ColaboradorEntity modelToEntity (Colaborador colaborador);


}
