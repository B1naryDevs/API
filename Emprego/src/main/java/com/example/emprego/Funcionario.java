package com.example.emprego;

public class Funcionario {

     String nome;

     String email;

     String empresa;

     long telefone;

     long cpf;

     String senha;

     String funcao;

     String acesso;

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Integer getAprovados() {
        return aprovados;
    }

    public void setAprovados(Integer aprovados) {
        this.aprovados = aprovados;
    }

    public Integer getReprovados() {
        return reprovados;
    }

    public void setReprovados(Integer reprovados) {
        this.reprovados = reprovados;
    }

    Integer vagas;
     Integer aprovados;
     Integer reprovados;

    public Funcionario(String nome_func, String email, long telefone) {

        this.nome = nome_func;
        this.email = email;
        this.telefone = telefone;

    }

    public Funcionario(String nome, Integer vagas, Integer aprovados, Integer reprovados) {
        this.nome = nome;
        this.vagas = vagas;
        this.aprovados = aprovados;
        this.reprovados = reprovados;

    }

    public Funcionario() {
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.funcao = funcao;
        this.acesso = acesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = String.valueOf(senha);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public Funcionario(String nome, String email, String empresa, long telefone, long cpf, String senha, String funcao, String acesso) {
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.funcao = funcao;
        this.acesso = acesso;
    }
}
