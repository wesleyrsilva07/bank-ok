package com.ifgoiano.bank.dao;

import com.ifgoiano.bank.dto.PessoaJuridica;
import com.ifgoiano.bank.connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaJuridicaDao extends PessoaDao {
    private final Connection conexao;
    private PreparedStatement stmt;

    public PessoaJuridicaDao() {
            this.conexao = new Connect().getConexao();
    }

    public void inserir(PessoaJuridica p) {//Método para persistir um objeto do tipo PessoaJuridica.
        String sql = "INSERT INTO pessoa_juridica (id_pessoa, cnpj) VALUES(?, ?)";//Sql referente a inserção na tabela 'pessoa_Juridica'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getCnpj());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(PessoaJuridica p) {//Método para alterar um objeto do tipo PessoaJuridica.
        String sql = "UPDATE pessoa_juridica SET cnpj = ? WHERE id_pessoa = ?;";//Sql referente a atualização na tabela 'pessoa_juridica'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getCnpj());
            stmt.setInt(2, p.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
