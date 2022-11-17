package com.example.emprego;

public class Tema {

    public static boolean modo;

    public Tema() {}

    public Tema(boolean modo) {this.modo = modo;}

    public static boolean getModo() {
        return modo;
    }

    public static void setModo(String nome) {Tema.modo = modo;}
}

