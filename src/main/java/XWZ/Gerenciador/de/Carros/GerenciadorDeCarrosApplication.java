package XWZ.Gerenciador.de.Carros;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class GerenciadorDeCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeCarrosApplication.class, args);
	}


}
