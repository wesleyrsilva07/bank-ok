package com.ifgoiano.bank.dao;

import com.ifgoiano.bank.dto.PessoaFisica;
import com.ifgoiano.bank.dto.PessoaJuridica;
import com.ifgoiano.bank.connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaDao {
    private final Connection conexao;
    private PreparedStatement stmt;

    public PessoaDao() {
            this.conexao = new Connect().getConexao();
    }

    public PessoaFisica inserirPessoa(PessoaFisica p) {//Metodo para persistir um objeto do tipo PessoaFisica.
        String sql = "INSERT INTO pessoa(nome, endereco) VALUES(?, ?)";//Sql referente a insercao na tabela 'pessoa'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            p.setId(rs.getInt(1));//Atribui o id do objeto pessoaFisica.
            
            stmt.close();

            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public PessoaJuridica inserirPessoa(PessoaJuridica p) {//Metodo para persistir um objeto do tipo PessoaJuridica.
        String sql = "INSERT INTO pessoa(nome, endereco) VALUES(?, ?)";//Sql referente a inserÁ„o na tabela 'pessoa'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            p.setId(rs.getInt(1));//Atribui o id do objeto pessoaJuridica.
            
            stmt.close();

            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterarPessoa(PessoaFisica p) {//MÈtodo para alterar um objeto do tipo PessoaFisica.
        String sql = "UPDATE pessoa SET nome = ?, endereco = ? WHERE id = ?;";//Sql referente a atualiza√ß√£o na tabela 'pessoa'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.setInt(3, p.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterarPessoa(PessoaJuridica p) {//MÈtodo para alterar um objeto do tipo PessoaJuridica.
        String sql = "UPDATE pessoa SET nome = ?, endereco = ? WHERE id = ?;";//Sql referente a atualiza√ß√£o na tabela 'pessoa'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.setInt(3, p.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
