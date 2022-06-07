package io.github.lcruz8;

import io.github.lcruz8.domain.entity.Cliente;
import io.github.lcruz8.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init (@Autowired Clientes clientes) {

        return args -> {
                //Insere os dois objetos no banco
                Cliente cliente = new Cliente();
                cliente.setNome("Lane");
                cliente.setTelefone("9188888-8888");
                clientes.salvar(cliente);

                Cliente cliente2 = new Cliente();
                cliente2.setNome("Loulou");
                cliente2.setTelefone("9199999-9999");
                clientes.salvar(cliente2);

                //Recupera a listagem de clientes
                List<Cliente> vClientes = clientes.recuperarTodos();
                vClientes.forEach(System.out::println);

                //Laço para alteração dos objetos
                vClientes.forEach(object-> {
                    object.setNome(object.getNome()+" - upd");
                    clientes.alterar(object);
                });


                //Busca a lista de clientes
                List<Cliente> vClienteAtl = clientes.recuperarPorNome("upd");
                vClienteAtl.forEach(System.out::println);

                vClienteAtl.forEach(c -> {
                    clientes.excluir(c);
                });

                List<Cliente> vClientes2 = clientes.recuperarTodos();
                if(vClientes2.isEmpty()) {
                    System.out.println("Não há o que recuperar");
                } else {
                    vClientes2.forEach(System.out::println);
                }

        };
    }



    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

