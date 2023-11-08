package demonstracaoboaspraticas.boaspraticas.feature.steps.cadastrarcolaborador;

import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.mapper.MapperColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.mapper.MapperColaboradorEntityImpl;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.ColaboradorRepository;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.entity.ColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.services.DefinirSalarioColaboradorExternoService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CadastrarColaboradoExternoTest {

    @Mock
    ColaboradorRepository colaboradorRepository;
    @Mock
    MapperColaboradorEntity mockedMapperColaboradorEntity;
    @InjectMocks
    DefinirSalarioColaboradorExternoService mockedDefinirSalarioColaboradorExternoService;
    @Mock
    ColaboradorEntity mockedColaboradorEntity;

    private ColaboradorEntity resultado;
    private Colaborador colaborador;
    private Colaborador novoSalario;
    private Double valorAlteradoManualmente;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockedColaboradorEntity = new ColaboradorEntity();
        this.mockedMapperColaboradorEntity = new MapperColaboradorEntityImpl();
        this.mockedDefinirSalarioColaboradorExternoService = new DefinirSalarioColaboradorExternoService();
    }

    @Given("que necessito cadastrar um colaborador externo com os dados basicos suficientes")
    public void que_necessito_cadastrar_um_colaborador_externo_com_os_dados_basicos_suficientes() {
       mockedColaboradorEntity.setIdColaborador(1L);
       mockedColaboradorEntity.setCpfColaborador("711.331.430-91");
       mockedColaboradorEntity.setNomeColaborador("Augusto Barbosa");
       mockedColaboradorEntity.setTelefoneColaborador("11956418889");
       mockedColaboradorEntity.setTipoColaborador("externo");
       mockedColaboradorEntity.setSalarioColaborador(BigDecimal.valueOf(5000.00));
    }
    @When("um novo colaborador da area externo e contratado")
    public void um_novo_colaborador_da_area_externo_e_contratado() {

        valorAlteradoManualmente = 5000.00;
        colaborador = mockedMapperColaboradorEntity.entityToModel(mockedColaboradorEntity);
        novoSalario = mockedDefinirSalarioColaboradorExternoService.definirSalarioColaborador(colaborador);
        resultado = mockedMapperColaboradorEntity.modelToEntity(novoSalario);

        Double valorAlterado = resultado.getSalarioColaborador().doubleValue();
        valorAlteradoManualmente = valorAlteradoManualmente * 3;
        Assertions.assertEquals(valorAlterado,valorAlteradoManualmente);
        colaboradorRepository.save(resultado);
        verify(colaboradorRepository, atLeast(1)).save(resultado);
    }
    @Then("a aplicacao deve retornar que o colaborador externo foi cadastro com suceso")
    public void a_aplicacao_deve_retornar_que_o_colaborador_externo_foi_cadastro_com_suceso() {
        Assertions.assertEquals(resultado.getCpfColaborador(), mockedColaboradorEntity.getCpfColaborador());
        Assertions.assertEquals(resultado.getNomeColaborador(), mockedColaboradorEntity.getNomeColaborador());
        Assertions.assertEquals(resultado.getTelefoneColaborador(), mockedColaboradorEntity.getTelefoneColaborador());
        Assertions.assertEquals(resultado.getTipoColaborador(), mockedColaboradorEntity.getTipoColaborador());
        Assertions.assertNotEquals(resultado.getSalarioColaborador(), mockedColaboradorEntity.getSalarioColaborador());
    }

}
