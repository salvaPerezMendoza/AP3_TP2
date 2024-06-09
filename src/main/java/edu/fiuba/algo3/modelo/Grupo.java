package edu.fiuba.algo3.modelo;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class Grupo {
    private String nombre;
    private HashSet<String> contenidoGrupo;

    private HashSet<String> getContenidoGrupo() {
        return contenidoGrupo;
    }

    public Grupo(){
        this.nombre = "default";
        this.contenidoGrupo = new HashSet<>();
    }

    public Grupo(String nombre, String... args) {
        this.nombre = nombre;
        this.contenidoGrupo = new HashSet<>(asList(args));
    }

    public void agregarAlGrupo(String nombre) {
        this.contenidoGrupo.add(nombre);
    }

    public boolean asIgualAlGrupo(Grupo grupo) {
        return this.contenidoGrupo.equals(grupo.contenidoGrupo);
    }
}
