package edu.fiuba.algo3.modelo.bonificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class MultiplicadorX2Decorador extends BonificadorDecorador{
    public MultiplicadorX2Decorador(Bonificador wrapped){
        super(wrapped);
    }
    public int modificarPuntaje(int puntaje){
        // Llamamos al método del decorador envuelto primero
        int nuevoPuntaje = super.modificarPuntaje(puntaje);

            nuevoPuntaje *= 2;




        return nuevoPuntaje;

    }

}