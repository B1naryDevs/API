package com.example.emprego;

public class Cargo {
    public static String nome;
    public Cargo(){}

    public Cargo(String nome){
        this.nome=nome;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Cargo.nome = nome;
    }

}
