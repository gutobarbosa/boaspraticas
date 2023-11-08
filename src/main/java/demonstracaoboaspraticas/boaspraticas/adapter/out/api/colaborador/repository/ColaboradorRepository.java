package demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository;

import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.entity.ColaboradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity,Long> {

    ColaboradorEntity findByNomeColaborador(String nomeColaborador);
    ColaboradorEntity findByidColaborador(Long id);

}
