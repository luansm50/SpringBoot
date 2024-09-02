package io.github.luansm50.spring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.luansm50.spring.domain.dto.LicitacaoDataDTO;
import io.github.luansm50.spring.service.LicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@SpringBootApplication
@RestController
public class Application {


    @Bean
    public CommandLineRunner init(@Autowired LicitacaoService service, @Value("${licitacao.filepath}") String filePath) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            LicitacaoDataDTO data = mapper.readValue(new File(filePath), LicitacaoDataDTO.class);
            service.init(data);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
