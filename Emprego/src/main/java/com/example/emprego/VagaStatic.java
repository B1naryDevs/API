package com.example.emprego;

public class VagaStatic {
    private static String cargo;
    private static String periodo;
    private static String experiencia;
    private static float salario;
    private static String descricao;
    private static String endereco;
    private static String cidade;
    private static String empresa_vaga;
    private static String setor_vaga;
    private static String remoto;
    private static String status_vaga;

    private static long funcionario;

    private static Integer Id;

    public VagaStatic(){}

    public VagaStatic(String cargo,String periodo,String experiencia,float salario,String descricao,String cidade,String endereco,String empresa_vaga, String setor_vaga,String remoto,String status_vaga){
        this.cargo = cargo;
        this.periodo = periodo;
        this.experiencia = experiencia;
        this.salario = salario;
        this.descricao = descricao;
        this.cidade = cidade;
        this.endereco = endereco;
        this.empresa_vaga = empresa_vaga;
        this.setor_vaga = setor_vaga;
        this.remoto = remoto;
        this.status_vaga = status_vaga;
    }

    public VagaStatic(String cargo,String periodo,float salario,String experiencia,String descricao,String remoto, Integer Id){
        this.cargo = cargo;
        this.periodo = periodo;
        this.salario = salario;
        this.experiencia = experiencia;
        this.descricao = descricao;
        this.remoto = remoto;
        this.Id = Id;
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

    public String getSetor_vaga() {
        return setor_vaga;
    }

    public void setSetor_vaga(String setor_vaga) {
        this.setor_vaga = setor_vaga;
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
