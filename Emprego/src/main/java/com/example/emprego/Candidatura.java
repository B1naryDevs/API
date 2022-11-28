package com.example.emprego;

public class Candidatura {

    private String cargo;
    private Integer codigo;
    private String data;
    private String status;

    private long funcionario;

    public Candidatura(String cargo, Integer codigo, String data, String status, long funcionario){
        this.cargo = cargo;
        this.codigo = codigo;
        this.data = data;
        this.status = status;
        this.funcionario = funcionario;
    }

    public Candidatura(String cargo, String data, String status){
        this.cargo = cargo;
        this.data = data;
        this.status = status;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(long funcionario) {
        this.funcionario = funcionario;
    }
}
