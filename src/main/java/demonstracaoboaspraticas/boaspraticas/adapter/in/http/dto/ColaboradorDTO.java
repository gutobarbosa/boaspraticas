package demonstracaoboaspraticas.boaspraticas.adapter.in.http.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColaboradorDTO {

    @JsonProperty("id_colaborador")
    private Long idColaborador;

    @CPF
    @JsonProperty("cpf_colaborador")
    private String cpfColaborador;

    @NotEmpty
    @Length(min = 5,max = 50)
    @JsonProperty("nome_colaborador")
    private String nomeColaborador;

    @NotEmpty
    @Length(min = 11,max = 11)
    @JsonProperty("telefone_colaborador")
    private String telefoneColaborador;

    @NotEmpty
    @Length(min = 7,max = 7)
    @JsonProperty("tipo_colaborador")
    private String tipoColaborador;

    @NotEmpty
    @Length(min = 3,max = 20)
    @JsonProperty("salario_colaborador")
    private String salarioColaborador;

}
