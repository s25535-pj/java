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
                .title("Currency service rest api")
                .description("Api that returns rate of choosen currency for set amount of days");

        return new OpenAPI().info(info);
    }
}
