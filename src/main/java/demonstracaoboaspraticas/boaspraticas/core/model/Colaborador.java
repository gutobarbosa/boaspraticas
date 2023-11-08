package demonstracaoboaspraticas.boaspraticas.core.model;


import lombok.*;

import java.math.BigDecimal;

@Data
public class Colaborador {
    private Long idColaborador;
    private String cpfColaborador;
    private String nomeColaborador;
    private String telefoneColaborador;
    private String tipoColaborador;
    private BigDecimal salarioColaborador;
}
