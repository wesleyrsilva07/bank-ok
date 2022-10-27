package com.ifgoiano.bank;

import com.ifgoiano.bank.dao.ContaDao;
import com.ifgoiano.bank.dao.PessoaDao;
import com.ifgoiano.bank.dao.PessoaFisicaDao;
import com.ifgoiano.bank.dao.PessoaJuridicaDao;
import com.ifgoiano.bank.dto.Conta;
import com.ifgoiano.bank.dto.PessoaFisica;
import com.ifgoiano.bank.dto.PessoaJuridica;

public class Bank {

    public static void main(String[] args) {
        // Realização de testes.
        PessoaFisica p1 = new PessoaFisica("Ana", "Rua 1", "123.456.789-01");
        PessoaFisicaDao pf = new PessoaFisicaDao();
        
        
        p1.setNome("Ana Maria");
        p1.setEndereco("Rua 02");
        p1.setCpf("222.222.222-22");
        pf.inserir(p1);
        
        Conta c1 = new Conta(p1, 1111, 10.0, 1);
        ContaDao c = new ContaDao();
        
        c.inserir(c1);
        c1.setNumero(1234);
        c.alterar(c1);
        c1.setStatus(c.desativar(c1).getStatus());
        
        PessoaJuridica p2 = new PessoaJuridica("IF Goiano", "Rua 2", "00.111.222/0001-11");
        PessoaJuridicaDao pj = new PessoaJuridicaDao();
        
        pj.inserir(pj.inserirPessoa(p2));
        p2.setNome("IF Goiano - Campus Ceres");
        p2.setCnpj("11.222.333/0001-44");
        pj.alterarPessoa(p2);
        pj.alterar(p2);
        System.out.println("Cadastro realizado.");
        
    }
}
