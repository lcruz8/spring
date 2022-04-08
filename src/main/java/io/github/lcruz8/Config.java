package io.github.lcruz8;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Config {
    //Objeto string com este valor no contexto
    //@Bean dá um nome específico, se o parâmetro name não for especificado, pega o nome do método abaixo
    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema de vendas";
    }
}
