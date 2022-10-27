package com.ifgoiano.bank.dto;

public class Conta {
    private int id;
    public Pessoa pessoa;
    private long numero;
    private double saldo;
    private int status;

    public Conta(Pessoa pessoa, long numero, double saldo, int status) {
        this.pessoa = pessoa;
        this.numero = numero;
        this.saldo = saldo;
        this.status = status;
    }
    
    public Conta(int id, Pessoa pessoa, long numero, double saldo, int status) {
        this.id = id;
        this.pessoa = pessoa;
        this.numero = numero;
        this.saldo = saldo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
