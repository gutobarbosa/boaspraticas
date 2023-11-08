package demonstracaoboaspraticas.boaspraticas.feature.steps.cadastrarcolaborador;

import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.mapper.MapperColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.mapper.MapperColaboradorEntityImpl;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.ColaboradorRepository;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.entity.ColaboradorEntity;
import demonstracaoboaspraticas.boaspraticas.core.model.Colaborador;
import demonstracaoboaspraticas.boaspraticas.core.services.DefinirSalarioColaboradorInternoService;
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
public class CadastrarColaboradorInternoTest {

    @Mock
    ColaboradorRepository colaboradorRepository;
    @Mock
    MapperColaboradorEntity mockedMapperColaboradorEntity;
    @InjectMocks
    DefinirSalarioColaboradorInternoService mockedDefinirSalarioColaboradorInternoService;
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
        this.mockedDefinirSalarioColaboradorInternoService = new DefinirSalarioColaboradorInternoService();
    }

    @Given("que o cpf do analista é valido e o numero é {string}")
    public void queOCpfDoAnalistaÉValidoEONumeroÉ(String cpf) {
        mockedColaboradorEntity = new ColaboradorEntity();
        mockedColaboradorEntity.setIdColaborador(1L);
        mockedColaboradorEntity.setCpfColaborador(cpf);
    }

    @Given("que o nome do analista é {string}")
    public void queONomeDoAnalistaÉ(String nome) {
        mockedColaboradorEntity.setNomeColaborador(nome);
    }

    @Given("que o telefone do analista é {string}")
    public void queOTelefoneDoAnalistaÉ(String telefone) {
        mockedColaboradorEntity.setTelefoneColaborador(telefone);
    }

    @Given("que o tipo do analista é {string}")
    public void queOTipoDoAnalistaÉ(String tipo) {
        mockedColaboradorEntity.setTipoColaborador(tipo);
    }

    @Given("que o salario do analista é {double}")
    public void queOSalarioDoAnalistaÉ(Double double1) {
        mockedColaboradorEntity.setSalarioColaborador(BigDecimal.valueOf(double1));
        valorAlteradoManualmente = double1;
        colaborador = mockedMapperColaboradorEntity.entityToModel(mockedColaboradorEntity);
        novoSalario = mockedDefinirSalarioColaboradorInternoService.definirSalarioColaborador(colaborador);
        resultado = mockedMapperColaboradorEntity.modelToEntity(novoSalario);
    }

    @When("um novo colaborador da area de arquitetura esta sendo contratado")
    public void umNovoColaboradorDaAreaDeArquiteturaEstaSendoContratado() {
        Double valorAlterado = resultado.getSalarioColaborador().doubleValue();
        valorAlteradoManualmente = valorAlteradoManualmente * 5;
        Assertions.assertEquals(valorAlterado,valorAlteradoManualmente);
        colaboradorRepository.save(resultado);
        verify(colaboradorRepository, atLeast(1)).save(resultado);
    }

    @Then("a aplicacao deve retornar que o colaborador de arquitetura foi cadastro com suceso na base")
    public void aAplicacaoDeveRetornarQueOColaboradorDeArquiteturaFoiCadastroComSucesoNaBase() {
        Assertions.assertEquals(resultado.getCpfColaborador(), mockedColaboradorEntity.getCpfColaborador());
        Assertions.assertEquals(resultado.getNomeColaborador(), mockedColaboradorEntity.getNomeColaborador());
        Assertions.assertEquals(resultado.getTelefoneColaborador(), mockedColaboradorEntity.getTelefoneColaborador());
        Assertions.assertEquals(resultado.getTipoColaborador(), mockedColaboradorEntity.getTipoColaborador());
        Assertions.assertNotEquals(resultado.getSalarioColaborador(), mockedColaboradorEntity.getSalarioColaborador());
    }
}
