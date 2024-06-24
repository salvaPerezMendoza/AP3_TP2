package edu.fiuba.algo3.modelo.bonificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class AnuladorPuntajeDecorador extends BonificadorDecorador{
    public AnuladorPuntajeDecorador(Bonificador wrapped){
        super(wrapped);
    }
    public int modificarPuntaje(int puntaje) {
        return 0;
    }
}