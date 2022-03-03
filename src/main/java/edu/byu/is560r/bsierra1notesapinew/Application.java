package edu.byu.is560r.bsierra1notesapinew;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "bwh5 Notes API", version = "v1", description = "Notes API Application"))
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}