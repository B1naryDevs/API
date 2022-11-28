package com.example.emprego;

public class Usuario {

    public static String email;
    public static Long cpf;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Usuario.email = email;
    }

    public static Long getCpf() {
        return cpf;
    }

    public static void setCpf(Long cpf) {
        Usuario.cpf = cpf;
    }
}
