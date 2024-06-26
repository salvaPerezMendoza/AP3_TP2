package edu.fiuba.algo3.modelo.bonificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class BonificadorDecorador implements Bonificador{
    private Bonificador wrapped;

    BonificadorDecorador(Bonificador wrapped){
        this.wrapped = wrapped;
    }
    public int modificarPuntaje(int puntaje){
        return wrapped.modificarPuntaje(puntaje);
    }
    // Método de fabrica para crear decoradores
    public static Bonificador crearDecorador(Bonificador bonificadorExistente, Bonificador newBonificador, Jugador jugadorQueAplicoBonificador, Jugador jugadorDeLaPregunta) {

        //Si fue el jugador quien agrego el bonificador
        if (jugadorQueAplicoBonificador.equals(jugadorDeLaPregunta)) {
            if (newBonificador instanceof MultiplicadorX2Decorador) {
                return new MultiplicadorX2Decorador(bonificadorExistente);
            }
        }
        //Si NO fue el jugador quien agrego el bonificador
        if (!jugadorQueAplicoBonificador.equals(jugadorDeLaPregunta)) {
            if (newBonificador instanceof AnuladorPuntajeDecorador) {
                return new AnuladorPuntajeDecorador(bonificadorExistente);
            }
        }
        // Se aplica Exclusvidad a cualquier jugador
        if (newBonificador instanceof ExclusividadPuntajeDecorador) {
            return new ExclusividadPuntajeDecorador(bonificadorExistente);
        }

        return bonificadorExistente;
    }
}