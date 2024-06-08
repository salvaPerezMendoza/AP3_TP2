package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class RespuestaMultipleChoice implements Respuesta{
    private ArrayList opciones;

    public RespuestaMultipleChoice(ArrayList opciones) {
        this.opciones = opciones;
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
}
