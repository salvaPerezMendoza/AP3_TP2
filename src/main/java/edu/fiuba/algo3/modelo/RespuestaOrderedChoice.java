package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class RespuestaOrderedChoice implements Respuesta {
    private ArrayList<String> respuesta;

    private ArrayList<String> getRespuesta() {
        return respuesta;
    }

    public RespuestaOrderedChoice(String... args) {
        this.respuesta = new ArrayList<>(asList(args));
    }

    @Override
    public boolean validarRespuesta(Respuesta respuestaJugador) {
        RespuestaOrderedChoice respuesta = (RespuestaOrderedChoice) respuestaJugador;
        ArrayList<String> listaRespuesta = respuesta.getRespuesta();
        return listaRespuesta.equals(this.respuesta);
    }
}
