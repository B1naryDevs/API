package com.example.emprego;

import java.awt.*;

public class Tema{
    static Boolean luz = false;
    public Tema(){}

    public static Boolean getLuz() {
        return luz;
    }
    public static void setLuz(Boolean luz) {
        Tema.luz = luz;
    }
}