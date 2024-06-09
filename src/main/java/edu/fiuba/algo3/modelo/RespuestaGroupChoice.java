package edu.fiuba.algo3.modelo;

import java.util.HashSet;

public class RespuestaGroupChoice implements Respuesta  {
    Grupo grupoA;
    Grupo grupoB;

    private Grupo getGrupoA() {
        return grupoA;
    }

    private Grupo getGrupoB() {
        return grupoB;
    }

    public void agregarElementoGrupoA(String string){
        grupoA.agregarAlGrupo(string);
    }

    public void agregarElementoGrupoB(String string){
        grupoB.agregarAlGrupo(string);
    }

    public RespuestaGroupChoice() {
        this.grupoA = new Grupo();
        this.grupoB = new Grupo();
    }

    public RespuestaGroupChoice(Grupo grupoA, Grupo grupoB) {
        this.grupoA = grupoA;
        this.grupoB = grupoB;
    }

    @Override
    public boolean validarRespuesta(Respuesta respuestaJugador) {
        RespuestaGroupChoice respuesta = (RespuestaGroupChoice) respuestaJugador;
        return grupoA.asIgualAlGrupo(respuesta.getGrupoA()) && grupoB.asIgualAlGrupo(respuesta.getGrupoB());
    }
}
