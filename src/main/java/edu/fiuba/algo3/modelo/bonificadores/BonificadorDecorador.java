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
}