package demonstracaoboaspraticas.boaspraticas.adapter.in.http.get;

import demonstracaoboaspraticas.boaspraticas.adapter.in.http.dto.ColaboradorDTO;
import demonstracaoboaspraticas.boaspraticas.adapter.in.http.mapper.MapperColaboradorModel;
import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.ports.in.ConsultarColaboradorPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequiredArgsConstructor
public class ControllerConsultaColaborador {

    @Autowired
    ConsultarColaboradorPort consultarColaboradorPort;
    @Autowired
    MapperColaboradorModel mapperColaborador;

    @GetMapping("/mostrarnome")
    public ResponseEntity ConsultarColaborador(@RequestParam String nomeColaborador) {
        ColaboradorDTO colaboradorDTO = null;


        // Enviando informacao para o core com o dado do tipo correto (model)
        Colaborador colaboradorModel = consultarColaboradorPort.consultarNomeColaborador(nomeColaborador);

        // Convertendo saida do dado de Model para DTO para que a info seja retornada para o usuario no padrao correto
        colaboradorDTO = mapperColaborador.modelToDto(colaboradorModel);

        //retornando a informacao para o usuario no padrao correto
        return ResponseEntity.ok(colaboradorDTO);
    }

    @GetMapping("/encontrarid/{id}")
    public ResponseEntity ConsultarFuncionarioPorId(@PathVariable Long id) {

        ColaboradorDTO colaboradorDTO = null;

        // Enviando informacao para o core com o dado do tipo correto (model)
        Colaborador colaboradorModel = consultarColaboradorPort.consultarNomeColaboradorPeloID(id);

        // Convertendo saida do dado de Model para DTO para que a info seja retornada para o usuario no padrao correto
        colaboradorDTO = mapperColaborador.modelToDto(colaboradorModel);

        //retornando a informacao para o usuario no padrao correto
        return ResponseEntity.ok(colaboradorDTO);
    }
}
