package edu.fiuba.algo3.modelo.bonificadores;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Ronda;

import java.util.ArrayList;

public class ExclusividadPuntajeDecorador extends BonificadorDecorador{
    public ExclusividadPuntajeDecorador(Bonificador wrapped){
        super(wrapped);
    }

    public int modificarPuntaje(int puntaje){
        // Llamamos al método del decorador envuelto primero
        int nuevoPuntaje = super.modificarPuntaje(puntaje);
        Ronda ronda = Juego.obtenerRonda(); // Obtener la instancia actual de Ronda


            ArrayList<Pregunta> preguntas = ronda.getPreguntas();
            ArrayList<Jugador> jugadores = ronda.getJugadores();
                int cantidadIncorrectas = 0;
                for (Pregunta pregunta : preguntas) {
                    if (!pregunta.ningunaIncorrecta()) {
                        cantidadIncorrectas++;
                    }
                }
                // Si un solo jugador respondio bien se le aplica un "multiplicadorX2 exclusivo"
                if (jugadores.size() - cantidadIncorrectas == 1) {
                    nuevoPuntaje *= 2;
                }

        return nuevoPuntaje;

    }

}
