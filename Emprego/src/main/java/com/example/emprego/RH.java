package com.example.emprego;

public class RH {

    private static String nome;

    private static String email;

    private static String empresa;

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        RH.nome = nome;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        RH.email = email;
    }

    public static String getEmpresa() {
        return empresa;
    }

    public static void setEmpresa(String empresa) {
        RH.empresa = empresa;
    }

    public RH() {
    }
}
