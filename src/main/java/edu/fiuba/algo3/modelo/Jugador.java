package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.bonificadores.AnuladorPuntajeDecorador;
import edu.fiuba.algo3.modelo.excepciones.JugadorNoTieneMasBonificadorError;

public class Jugador {
    private String nombre;
    private int puntajeTotal;
    private int usosMultiplicadorX2;
    private int usosExclusividad;
    private int usosAnulador;

    private static final int MAX_USOS_MULTIPLICADOR_X2 = 2;
    private static final int MAX_USOS_EXCLUSIVIDAD = 2;
    private static final int MAX_USOS_ANULADOR = 1;
    public Jugador(String nombreJugador) {
        nombre = nombreJugador;
        usosMultiplicadorX2 = 0;
        usosExclusividad = 0;
        usosAnulador = 0;
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

    public void usarMultiplicadorX2(Ronda ronda)  {
        if (usosMultiplicadorX2 < MAX_USOS_MULTIPLICADOR_X2) {
            this.usosMultiplicadorX2++;
            ronda.agregarBonificador(this,"MultiplicadorX2");
        }
    }

    public void usarExclusividad(Ronda ronda){
        if (usosExclusividad < MAX_USOS_EXCLUSIVIDAD) {
            this.usosExclusividad++;
            ronda.incrementarContadorExclusividad();
        }
    }

    public void usarAnulador(Ronda ronda){
        if (usosAnulador < MAX_USOS_ANULADOR) {
            this.usosAnulador++;
            ronda.agregarBonificador(this,"Anulador");
        }

    }
}

    

