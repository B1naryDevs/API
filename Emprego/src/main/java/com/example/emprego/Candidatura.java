package com.example.emprego;

public class Candidatura {

    private String empresa = "Pro4tech";
    private String cargo;
    private Integer codigo;
    private String data;
    private String status;

    public Candidatura(String cargo, Integer codigo, String data, String status){
        this.cargo = cargo;
        this.codigo = codigo;
        this.data = data;
        this.status = status;
    }

    public Candidatura(String cargo, String data, String status){
        this.cargo = cargo;
        this.data = data;
        this.status = status;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
}
