package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;

import java.util.ArrayList;

public class GroupChoice implements TipoDePregunta {
    ArrayList<OpcionGrupo> opcionesCorrectas;

    public GroupChoice(ArrayList<OpcionGrupo> opcionesCorrectas){
        this.opcionesCorrectas = opcionesCorrectas;
    }

    @Override
    public RespuestaCorregida corregirRespuesta(Respuesta respuestaJugador) {
        int cantidadCorrectas = 0;
        int cantidadIncorrectas = 0;
        ArrayList<Opcion> opcionesJugador = respuestaJugador.getOpciones();
        OpcionGrupo grupoA = (OpcionGrupo) opcionesJugador.get(0);
        OpcionGrupo grupoB = (OpcionGrupo) opcionesJugador.get(1);
        if(grupoA.esIgualA(opcionesCorrectas.get(0)) && grupoB.esIgualA(opcionesCorrectas.get(1))){
            cantidadCorrectas += 1;
        } else {
            cantidadIncorrectas += 1;
        }
        return new RespuestaCorregida(respuestaJugador.getJugador(), cantidadCorrectas, cantidadIncorrectas);
    }
}
