package edu.fiuba.algo3.modelo.bonificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class BonificadorConcreto implements Bonificador {
    public BonificadorConcreto() {

    }
    public int modificarPuntaje(int puntaje){
        return puntaje;
    }
}