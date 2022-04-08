package io.github.lcruz8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Dependencia - spring-boot-starter
@SpringBootApplication
//a classe manda mensagens para o browser através da rest controller||Dependencia - spring-boot-starter-web
@RestController
public class VendasApplication {

    // Qualifier = injeta o bean que faz referência a Config.applicationName na string applicationName desta classe
    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    //Mapeia o método para o browser enxergar - url_servidor/hello
    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName;

        //return "<h1>hello world</h1>";
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
