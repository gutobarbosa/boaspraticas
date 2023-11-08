package demonstracaoboaspraticas.boaspraticas.adapter.in.http.post;

import demonstracaoboaspraticas.boaspraticas.adapter.in.http.dto.ColaboradorDTO;
import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.ports.in.CadastrarColaboradorPort;
import demonstracaoboaspraticas.boaspraticas.adapter.in.http.mapper.MapperColaboradorModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequiredArgsConstructor
public class ControllerCadastrarColaborador {

        @Autowired
        CadastrarColaboradorPort cadastrarColaboradorPortIn;

        @Autowired
        MapperColaboradorModel mapperColaborador;

        // Controler nao necessita do try/catch pois o controller advice intercepta a requisicao e retorna a info antes mesmo de voltar a info para o controller
        @PostMapping("/colaborador/cadastrar")
          public ResponseEntity<ColaboradorDTO> cadastrarColaborador (@Valid @RequestBody ColaboradorDTO cadastrarColaboradorDTO){

                // Convertendo entrada em DTO para Model para continuidade da informacao para dentro do core
                Colaborador colaborador = mapperColaborador.dtoToModel(cadastrarColaboradorDTO);

                // Enviando informacao para o core com o dado do tipo correto (model)
                Colaborador colaboradorModel = cadastrarColaboradorPortIn.cadastrarColaborador(colaborador);

                // Convertendo saida do dado de Model para DTO para que a info seja retornada para o usuario no padrao correto
                ColaboradorDTO colaboradorDTO = mapperColaborador.modelToDto(colaboradorModel);

                //retornando a informacao para o usuario no padrao correto
                return ResponseEntity.ok(colaboradorDTO);

        }

}
