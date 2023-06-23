package zgapa.CurrencyConverterApplication.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig {

    // Sam się uzywa
    @Bean
    OpenAPI openAPI() {
        Info info = new Info()
                .title("Zwracałka średniej walut z ostatnich x dni")
                .description("Opis zwracałki średniej walut z ostatnich x dni");

        return new OpenAPI().info(info);
    }
}
