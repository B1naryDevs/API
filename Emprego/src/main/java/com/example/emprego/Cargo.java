package com.example.emprego;

public class Cargo {
    public static String nome;
    public static String setor;

    public Cargo(){}

    public Cargo(String nome,String setor){
        this.nome=nome;
        this.setor=setor;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String cargo) {
        Cargo.nome = nome;
    }

    public static String getSetor() {
        return setor;
    }

    public static void setSetor(String setor) {
        Cargo.setor = setor;
    }

}
