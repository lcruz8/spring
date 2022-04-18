package io.github.lcruz8;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Development
// @Profile("development") //Comentado na aula 12 - define o perfil a qual as configurações se aplicam
public class  Config {
    //Objeto string com este valor no contexto
    //@Bean dá um nome específico, se o parâmetro name não for especificado, pega o nome do método abaixo
   /*
   //Comentado na aula 11
   @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema de vendas";
    }*/
    @Bean // importante para a indexação
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("RODANDO CONFIG EM DEVELOPMENT");
        };
    }


}
