package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bonificador.AnuladorDePuntaje;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ronda {
    private Pregunta pregunta;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Bonificador> bonificadores;

    public Ronda(Pregunta pregunta) {
        this.pregunta = pregunta;
        this.jugadores = new ArrayList<>();
        this.bonificadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void agregarBonificador(Bonificador bonificador){
        bonificadores.add(bonificador);
    }

    public void procesarJugada(ArrayList<Respuesta> respuestas){
        ArrayList<RespuestaCorregida> respuestasCorregidas = respuestas.stream()
                .map(respuesta -> pregunta.validarRespuesta(respuesta))
                .collect(Collectors.toCollection(ArrayList::new));
        aplicarModificadores(respuestasCorregidas);
    }

    private void aplicarModificadores(ArrayList<RespuestaCorregida> respuestasCorregidas){
        for (Bonificador bonificador: bonificadores) {
            if (bonificador instanceof AnuladorDePuntaje) {
                ((AnuladorDePuntaje) bonificador).anularPuntajes(respuestasCorregidas, pregunta.getPenalidad());
            } else {
                respuestasCorregidas.stream().forEach(respuestaCorregida -> respuestaCorregida.asignarPuntaje(pregunta.getPenalidad(), bonificador));
            }
        }
    }
}
