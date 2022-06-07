package io.github.lcruz8.domain.entity;

import javax.persistence.*;

@Entity
//@Table - Mais utilizado quando a classe não tem o mesmo nome da tabela, ou quando se precisa de
// mais informações sobre schema, e etc.
@Table(name = "Cliente", schema = "")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Estratégia de geração do valor (auto-incremento)
    private Integer id;
    @Column(name = "id", length = 100, updatable = false) //Não obrigatório para colunas com o mesmo nome no bd
    private String nome;
    private String telefone;

    public Cliente() {

    }

    public Cliente(Integer id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
