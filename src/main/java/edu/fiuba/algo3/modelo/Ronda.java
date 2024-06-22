package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ronda {
    private ArrayList<Pregunta> preguntas;

    public Ronda(ArrayList<Pregunta> preguntas) {
        this.preguntas = new ArrayList<>();
    }

    public void agregarPreguntasRespondidas(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    public void aplicarExclusividad() {
        for (Pregunta pregunta : preguntas) {
            //Si el bonificador es igual al de exclusividad y se cumple esta condicion entonces asignar puntaje a cada jugador
            if ((pregunta1.ningunaIncorrecta && !pregunta2.ningunaIncorrecta()) ||

                    (!pregunta1.ningunaIncorrecta() && pregunta2.ningunaIncorrecta() ())){

            }
        }
    }
}
