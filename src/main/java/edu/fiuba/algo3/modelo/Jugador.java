package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bonificadores.*;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoTieneMasBonificadorError;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntajeTotal;
    private ArrayList<Bonificador> bonificadores = new ArrayList<>();

    //Constantes
    private static final int MAX_USOS_MULTIPLICADOR_X2 = 2;
    private static final int MAX_USOS_EXCLUSIVIDAD = 2;
    private static final int MAX_USOS_ANULADOR = 1;

    public Jugador(String nombreJugador) {
        nombre = nombreJugador;
        inicializarBonificadores();
    }

    public void responder(Pregunta pregunta, Respuesta respuestaJugador) {
        pregunta.agregarRespuesta(respuestaJugador);
    }
    public String getNombre(){return this.nombre;}

    public void sumarPuntos(int puntaje) {
        puntajeTotal += puntaje;
    }

    public int getPuntajeTotal(){
        return puntajeTotal;
    }

    public void usarMultiplicadorX2(Ronda ronda) {
        this.usarBonificador(new MultiplicadorX2Decorador(new BonificadorConcreto()), ronda);
    }

    public void usarExclusividad(Ronda ronda) {
        this.usarBonificador(new ExclusividadPuntajeDecorador(new BonificadorConcreto()), ronda);
    }

    public void usarAnulador (Ronda ronda){
        this.usarBonificador(new AnuladorPuntajeDecorador(new BonificadorConcreto()), ronda);

    }

    private void usarBonificador(Bonificador tipoBonificador, Ronda ronda) {
        for (Bonificador bonificador : bonificadores) {
            if (tipoBonificador.getClass().isInstance(bonificador)) {
                bonificadores.remove(bonificador);
                ronda.agregarBonificador(this, bonificador);
                break;
            }
        }
    }

    private void inicializarBonificadores() {
        for (int i = 0; i < MAX_USOS_MULTIPLICADOR_X2; i++) {
            bonificadores.add(new MultiplicadorX2Decorador(new BonificadorConcreto()));
        }

        for (int i = 0; i < MAX_USOS_EXCLUSIVIDAD; i++) {
            bonificadores.add(new ExclusividadPuntajeDecorador(new BonificadorConcreto()));
        }

        for (int i = 0; i < MAX_USOS_ANULADOR; i++) {
            bonificadores.add(new AnuladorPuntajeDecorador(new BonificadorConcreto()));
        }
    }


}

    

