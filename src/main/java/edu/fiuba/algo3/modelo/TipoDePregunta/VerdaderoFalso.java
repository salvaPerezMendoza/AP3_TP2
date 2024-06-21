package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaCorregida;

import java.util.ArrayList;

public class VerdaderoFalso implements TipoDePregunta {
    ArrayList<Opcion> opciones;
    Opcion opcionCorrecta;

    public VerdaderoFalso(Opcion opcionCorrecta){
        this.opciones = new ArrayList<>();
        this.opciones.add(new OpcionSimple("V"));
        this.opciones.add(new OpcionSimple("F"));
        this.opcionCorrecta = opcionCorrecta;
    }

    @Override
    public RespuestaCorregida corregirRespuesta(Respuesta respuestaJugador) {
        int cantidadCorrectas = 0;
        int cantidadIncorrectas = 0;
        ArrayList<Opcion> opcionesJugador = respuestaJugador.getOpciones();
        Opcion opcionJugador = opcionesJugador.get(0);
        if(opcionJugador.esIgualA(opcionCorrecta)){
            cantidadCorrectas += 1;
        }
        else {
            cantidadIncorrectas +=1;
        }
        return new RespuestaCorregida(respuestaJugador.getJugador(), cantidadCorrectas, cantidadIncorrectas);
    }
}
