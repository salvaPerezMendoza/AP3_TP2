package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionGrupo;

import java.util.ArrayList;
import java.util.HashSet;

public class GroupChoice implements TipoDePregunta {
    ArrayList<Opcion> opciones;
    ArrayList<OpcionGrupo> opcionesCorrectas;

    public GroupChoice(ArrayList<Opcion> opciones, ArrayList<OpcionGrupo> opcionesCorrectas){
        this.opciones = opciones;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    private OpcionGrupo getGrupo(String nombre){
        OpcionGrupo result = new OpcionGrupo("", new HashSet<>());
        int i = 0;
        while(result.getNombre().isEmpty() && i < opcionesCorrectas.size()){
            if(opcionesCorrectas.get(i).getNombre().equals(nombre)){
                result = opcionesCorrectas.get(i);
            }
            i++;
        }
        return result;
    }

    @Override
    public RespuestaCorregida corregirRespuesta(Respuesta respuestaJugador) {
        int cantidadCorrectas = 0;
        int cantidadIncorrectas = 0;
        ArrayList<Opcion> opcionesJugador = respuestaJugador.getOpciones();
        OpcionGrupo grupoA = (OpcionGrupo) opcionesJugador.get(0);
        OpcionGrupo grupoB = (OpcionGrupo) opcionesJugador.get(1);
        OpcionGrupo grupoACorrecto = (OpcionGrupo) getGrupo(grupoA.getNombre());
        OpcionGrupo grupoBCorrecto = (OpcionGrupo) getGrupo(grupoB.getNombre());

        if(grupoA.esIgualA(grupoACorrecto) && grupoB.esIgualA(grupoBCorrecto)){
            cantidadCorrectas += 1;
        } else {
            cantidadIncorrectas += 1;
        }
        return new RespuestaCorregida(respuestaJugador.getJugador(), cantidadCorrectas, cantidadIncorrectas);
    }
}
