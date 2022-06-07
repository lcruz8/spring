package io.github.lcruz8.domain.repositorio;
import io.github.lcruz8.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Exception translator, caso aconteça algum problema com o BD, o erro vem explicado bem formatado/
@Repository //classe que acessa o banco de dados e faz operações, é um @component
public class Clientes {

    private static String INSERT = "INSERT INTO Cliente(nome, telefone) VALUES (?,?)";
    private static String SELECT_ALL = "SELECT * FROM Cliente";
    private static String UPDATE = "UPDATE Cliente SET nome = ?, telefone = ? WHERE id = ?";

    private static String DELETE = "DELETE FROM Cliente WHERE id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, cliente.getNome(), cliente.getTelefone());
        return cliente;
    }

    public Cliente alterar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, cliente.getNome(), cliente.getTelefone(), cliente.getId());
        return cliente;
    }

    public Cliente excluir(Cliente cliente) {
        jdbcTemplate.update(DELETE, cliente.getId());
        return cliente;
    }

    public List<Cliente> recuperarPorNome(String nome) {
        return jdbcTemplate.query(SELECT_ALL .concat(" WHERE nome LIKE ?"), new Object[] {"%"+nome+"%"}, iteradorMapper());
    }
    public List<Cliente> recuperarTodos() {
        return jdbcTemplate.query(SELECT_ALL, iteradorMapper());
    }

    public RowMapper<Cliente> iteradorMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Cliente(resultSet.getInt("ID"), resultSet.getString("NOME"), resultSet.getString("TELEFONE"));
            }
        };
    }
}
