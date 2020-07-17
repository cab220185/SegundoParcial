package com.example.segundoparcial;

public class Persona {

    String nombre ;
    String telefono;

    public Persona(String nombre, String telefono){

        this.nombre = nombre ;
        this.telefono = telefono ;


    }

    public Persona (){


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        telefono = telefono;
    }


}
