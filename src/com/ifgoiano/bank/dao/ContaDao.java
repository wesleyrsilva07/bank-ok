package com.ifgoiano.bank.dao;

import com.ifgoiano.bank.dto.Conta;
import com.ifgoiano.bank.connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContaDao {
    private Connection conexao;
    private PreparedStatement stmt;

    public ContaDao() {
            this.conexao = new Connect().getConexao();
    }

    public Conta inserir(Conta conta) {//Método para persistir um objeto do tipo Conta.
        String sql = "INSERT INTO conta(numero, saldo, status, id_pessoa) VALUES(?, ?, ?, ?);";//Sql referente a inserção na tabela 'conta'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, conta.getNumero());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setInt(3, conta.getStatus());
            stmt.setInt(4, conta.getPessoa().getId());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            conta.setId(rs.getInt(1));//Atribui o id do objeto conta.
            stmt.close();

            return conta;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Conta conta) {//Método para alterar um objeto do tipo Conta.
        String sql = "UPDATE conta SET numero = ?, saldo = ?, status = ?, id_pessoa = ? WHERE id = ?;";//Sql referente a atualização na tabela 'conta'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, conta.getNumero());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setInt(3, conta.getStatus());
            stmt.setInt(4, conta.getPessoa().getId());
            stmt.setInt(5, conta.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Conta desativar (Conta conta) {//Método para desativar um objeto do tipo Conta.
        String sql = "UPDATE conta SET status = 0 WHERE id = ?;";//Sql referente a desativar conta.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, conta.getId());
            stmt.execute();
            stmt.close();
            
            conta.setStatus(0);
            
            return conta;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
