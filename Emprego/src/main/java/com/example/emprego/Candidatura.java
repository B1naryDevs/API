package com.example.emprego;

public class Candidatura {

    private static String empresa = "Pro4tech";
    private static String cargo;
    private static Integer codigo;
    private static String data;
    private static String status;

    public Candidatura(String cargo, Integer codigo, String data, String status){
        this.cargo = cargo;
        this.codigo = codigo;
        this.data = data;
        this.status = status;
    }

    public static String getEmpresa() {
        return empresa;
    }

    public static void setEmpresa(String empresa) {
        Candidatura.empresa = empresa;
    }

    public static String getCargo() {
        return cargo;
    }

    public static void setCargo(String cargo) {
        Candidatura.cargo = cargo;
    }

    public static Integer getCodigo() {
        return codigo;
    }

    public static void setCodigo(Integer codigo) {
        Candidatura.codigo = codigo;
    }

    public static String getData() {
        return data;
    }

    public static void setData(String data) {
        Candidatura.data = data;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Candidatura.status = status;
    }
}
