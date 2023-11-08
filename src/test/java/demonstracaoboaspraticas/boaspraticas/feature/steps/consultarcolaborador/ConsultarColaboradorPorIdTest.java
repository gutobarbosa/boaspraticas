package demonstracaoboaspraticas.boaspraticas.feature.steps.consultarcolaborador;


import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.ColaboradorRepository;
import demonstracaoboaspraticas.boaspraticas.adapter.out.api.colaborador.repository.entity.ColaboradorEntity;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarColaboradorPorIdTest{

    @Mock
    ColaboradorEntity mockedColaboradorEntity;
    @Mock
    ColaboradorRepository colaboradorRepository;


    Long id = 1L;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockedColaboradorEntity = new ColaboradorEntity();
    }

        @Given("existe um colaborador cadastrado no sistema")
        public void existe_um_colaborador_cadastrado_no_sistema() {
            mockedColaboradorEntity.setIdColaborador(id);
            mockedColaboradorEntity.setCpfColaborador("711.331.430-91");
            mockedColaboradorEntity.setNomeColaborador("Augusto Barbosa");
            mockedColaboradorEntity.setTelefoneColaborador("11956418889");
            mockedColaboradorEntity.setTipoColaborador("externo");
            mockedColaboradorEntity.setSalarioColaborador(BigDecimal.valueOf(5000.00));


        }
        @When("preciso consultar os dados de um colaborador")
        public void preciso_consultar_os_dados_de_um_colaborador() {
            colaboradorRepository.findByidColaborador(id);
            verify(colaboradorRepository, atLeast(1)).findByidColaborador(id);
        }
        @Then("a aplicacao deve retornar os dados do colaborador")
        public void a_aplicacao_deve_retornar_os_dados_do_colaborador() {
            Assertions.assertEquals(mockedColaboradorEntity.getIdColaborador(), id);
            Assertions.assertEquals(mockedColaboradorEntity.getCpfColaborador(), "711.331.430-91");
            Assertions.assertEquals(mockedColaboradorEntity.getNomeColaborador(), "Augusto Barbosa");
            Assertions.assertEquals(mockedColaboradorEntity.getTelefoneColaborador(), "11956418889");
            Assertions.assertEquals(mockedColaboradorEntity.getTipoColaborador(), "externo");
            Assertions.assertEquals(mockedColaboradorEntity.getSalarioColaborador(), BigDecimal.valueOf(5000.00));



        }
}
