package com.example.emprego;

import java.io.ObjectInputFilter;

public class Vaga {
    private String cargo;
    private String periodo;
    private String experiencia;
    private float salario;
    private String descricao;
    private String endereco;
    private String cidade;
    private String empresa_vaga;
    private String remoto;
    private String status_vaga;

    private long funcionario;

    private Integer Id;

    public Vaga(){}

    public Vaga(String cargo,String periodo,String experiencia,float salario,String descricao,String cidade,String endereco,String empresa_vaga, String remoto,String status_vaga){
        this.cargo = cargo;
        this.periodo = periodo;
        this.experiencia = experiencia;
        this.salario = salario;
        this.descricao = descricao;
        this.cidade = cidade;
        this.endereco = endereco;
        this.empresa_vaga = empresa_vaga;
        this.remoto = remoto;
        this.status_vaga = status_vaga;
    }

    public Vaga(String cargo, long funcionario, String periodo,float salario,String experiencia,String descricao,String remoto, Integer Id){
        this.cargo = cargo;
        this.funcionario = funcionario;
        this.periodo = periodo;
        this.salario = salario;
        this.experiencia = experiencia;
        this.descricao = descricao;
        this.remoto = remoto;
        this.Id = Id;
    }

    public Vaga(String cargo_vaga, long funcionario_cpf, String periodo, float salario, String experiencia, String descricao_vaga, String remoto, int id_vaga, String status_vaga) {
        this.cargo = cargo_vaga;
        this.funcionario = funcionario_cpf;
        this.periodo = periodo;
        this.salario = salario;
        this.experiencia = experiencia;
        this.descricao = descricao_vaga;
        this.remoto = remoto;
        this.Id = id_vaga;
        this.status_vaga = status_vaga;
    }

    public String getEmpresa_vaga() {
        return empresa_vaga;
    }

    public void setEmpresa_vaga(String empresa_vaga) {
        this.empresa_vaga = empresa_vaga;
    }

    public long getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(long funcionario) {
        this.funcionario = funcionario;
    }

    public String getRemoto() {
        return remoto;
    }

    public void setRemoto(String remoto) {
        this.remoto = remoto;
    }

    public String getStatus_vaga() {
        return status_vaga;
    }

    public void setStatus_vaga(String status_vaga) {
        this.status_vaga = status_vaga;
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

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getExperiencia() {
        return this.experiencia;
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

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getId() {
        return this.Id;
    }

}
