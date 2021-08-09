package conference.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        final var openAPI = new OpenAPI();
        final var info = new Info();
        info.setVersion("v1");
        info.setTitle("Conference test");

        openAPI.setInfo(info);

        return openAPI;
    }
}
