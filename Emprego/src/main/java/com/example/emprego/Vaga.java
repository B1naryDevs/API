package com.example.emprego;

public class Vaga {
    private static String cargo;
    private static String periodo;
    private static String expProfissional;
    private static float salario;
    private static String descricao;
    private static String endereco;
    private static String cidade;
    private static String empresa_vaga;
    private static String setor_vaga;
    private static String remote;
    private static String status_vaga;

    public Vaga(){}

    public Vaga(String cargo,String periodo,String expProfissional,float salario,String descricao,String cidade,String endereco,String empresa_vaga, String setor_vaga,String remote,String status_vaga){
        this.cargo = cargo;
        this.periodo = periodo;
        this.expProfissional = expProfissional;
        this.salario = salario;
        this.descricao = descricao;
        this.cidade = cidade;
        this.endereco = endereco;
        this.empresa_vaga = empresa_vaga;
        this.setor_vaga = setor_vaga;
        this.remote = remote;
        this.status_vaga = status_vaga;
    }

    public static String getEmpresa_vaga() {
        return empresa_vaga;
    }

    public static void setEmpresa_vaga(String empresa_vaga) {
        Vaga.empresa_vaga = empresa_vaga;
    }

    public static String getSetor_vaga() {
        return setor_vaga;
    }

    public static void setSetor_vaga(String setor_vaga) {
        Vaga.setor_vaga = setor_vaga;
    }

    public static String getRemote() {
        return remote;
    }

    public static void setRemote(String remote) {
        Vaga.remote = remote;
    }

    public static String getStatus_vaga() {
        return status_vaga;
    }

    public static void setStatus_vaga(String status_vaga) {
        Vaga.status_vaga = status_vaga;
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

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

}
