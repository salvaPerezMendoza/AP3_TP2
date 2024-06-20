package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Opcion.OpcionSecuencia;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaCorregida;

public class OrderedChoice implements TipoDePregunta {
    OpcionSecuencia opcionCorrecta;

    public OrderedChoice(OpcionSecuencia opcionCorrecta){
        this.opcionCorrecta = opcionCorrecta;
    }

    @Override
    public RespuestaCorregida corregirRespuesta(Respuesta respuestaJugador) {
        int cantidadCorrectas = 0;
        int cantidadIncorrectas = 0;
        OpcionSecuencia opcionesJugador = (OpcionSecuencia) respuestaJugador.getOpciones().get(0);
        if(opcionesJugador.esIgualA(opcionCorrecta)) {
            cantidadCorrectas += 1;
        } else {
            cantidadIncorrectas += 1;
        }
        return new RespuestaCorregida(respuestaJugador.getJugador(), cantidadCorrectas, cantidadIncorrectas);
    }
}
