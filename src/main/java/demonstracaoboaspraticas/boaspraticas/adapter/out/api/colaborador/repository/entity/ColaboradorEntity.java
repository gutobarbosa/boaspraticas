package demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Data
@Table(name = "colaborador")
public class ColaboradorEntity {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "ID", nullable = false)
        private Long idColaborador;

        @Column(name = "CPF", length = 20, nullable = false)
        private String cpfColaborador;

        @Column(name = "NOME", length = 100, nullable = false)
        private String nomeColaborador;

        @Column(name = "TELEFONE", length = 13, nullable = false)
        private String telefoneColaborador;

        @Column(name = "TIPO_COLABORADOR", length = 20, nullable = false)
        private String tipoColaborador;

        @Column(name = "SALARIO", nullable = false)
        private BigDecimal salarioColaborador;


    }

