package io.github.lcruz8.services;

import io.github.lcruz8.model.Cliente;
import io.github.lcruz8.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
*  Serviços são classes que contém as regras de negócio de uma determinada funcionalidade
*/
@Service
public class ClientesService {
    private ClientesRepository repository;
    @Autowired
    public ClientesService( ClientesRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);

        //@Repository evita a instanciação excessiva de classes, deixando o sistema menos sobrecarregado
        //ClientesRepository repoClientes = new ClientesRepository(); ~> Linha não utilizada
        //repoClientes.persistir(cliente);
        repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente) {
        //aplica validações
    }
}
