package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class RespuestaMultipleChoice implements Respuesta{
    private ArrayList opciones;
    private Jugador jugador;

    public RespuestaMultipleChoice(ArrayList opciones, Jugador jugador) {
        this.opciones = opciones;
        this.jugador = jugador;
    }

    public RespuestaMultipleChoice(ArrayList opciones) {
        this.opciones = opciones;
    }

    public void agregarOpcion(Opcion opcion){
        opciones.add(opcion);
    }
    public ArrayList getOpciones() {
        return opciones;
    }

    @Override
    public boolean validarRespuesta(Respuesta respuestaJugador) {
        RespuestaMultipleChoice repuestaMultipleChoice = (RespuestaMultipleChoice) respuestaJugador;
        if(new HashSet<>(opciones).equals(new HashSet<>(repuestaMultipleChoice.getOpciones()))){
            return true;
        }
        return false;
    }

    @Override
    public Jugador getJugador() {
        return jugador;
    }
}
