package demonstracaoboaspraticas.boaspraticas;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\Augusto\\projeto_boaspraticas\\boaspraticas\\src\\test\\java\\demonstracaoboaspraticas\\boaspraticas\\feature"},
        plugin = "pretty",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
class BoaspraticasApplicationTests {

}
