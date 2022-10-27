package com.ifgoiano.bank.dao;

import com.ifgoiano.bank.dto.PessoaFisica;
import com.ifgoiano.bank.connect.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaFisicaDao{
    private final Connection conexao;
    private PreparedStatement stmt;
    

    public PessoaFisicaDao() {
            this.conexao = new Connect().getConexao();
    }

    public void inserir(PessoaFisica p) {//Método para persistir um objeto do tipo PessoaFisica.
    	PessoaDao pd = new PessoaDao();
    	p = pd.inserirPessoa(p);
        String sql = "INSERT INTO pessoa_fisica (id_pessoa, cpf) VALUES(?, ?)";//Sql referente a inserção na tabela 'pessoa_fisica'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(PessoaFisica p) {//Método para alterr um objeto do tipo PessoaFisica.
        String sql = "UPDATE pessoa_fisica SET cpf = ? WHERE id_pessoa = ?;";//Sql referente a atualização na tabela 'pessoa_fisica'.
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getCpf());
            stmt.setInt(2, p.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
