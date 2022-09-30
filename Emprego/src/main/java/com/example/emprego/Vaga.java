package com.example.emprego;

public class Vaga {
    private static String cargo;
    private static String periodo;
    private static String expProfissional;
    private static String salario;
    private static String descricao;
    private static Boolean remoto;

    private static String cep;
    private static String cidade;
    private static String estado;
    private static String numero;
    private static String endereco;
    private static  String bairro;
    private static String complemento;

    public Vaga(){}

    public Vaga(String cargo,String periodo,String expProfissional,String salario,String descricao,Boolean remoto,String cep,String cidade,String estado,String numero,String endereco,String bairro,String complemento){
        this.cargo = cargo;
        this.periodo = periodo;
        this.expProfissional = expProfissional;
        this.salario = salario;
        this.descricao = descricao;
        this.remoto = remoto;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.endereco = endereco;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setExpProfissional(String expProfissional) {
        this.expProfissional = expProfissional;
    }

    public String getExpProfissional() {
        return this.expProfissional;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getSalario() {
        return this.salario;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setRemoto(Boolean remoto) {
        this.remoto = remoto;
    }

    public Boolean getRemoto() {
        return this.remoto;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void  setBairro(String bairro){this.bairro = bairro;}

    public String getBairro(){return this.bairro;}

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return this.complemento;
    }

}
