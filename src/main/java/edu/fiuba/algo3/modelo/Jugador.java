package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.excepciones.JugadorNoTieneMasBonificadorError;

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

    public void sumarPuntos(int puntaje) {
        puntajeTotal += puntaje;
    }
    public int getPuntajeTotal(){
        return puntajeTotal;
    }

    public boolean usarMultiplicadorX2() throws JugadorNoTieneMasBonificadorError {
        if (usosMultiplicadorX2 < MAX_USOS_MULTIPLICADOR_X2) {
            this.usosMultiplicadorX2++;
            return true;
        }
        throw new JugadorNoTieneMasBonificadorError("El jugador ya ha usado el multiplicadorx2 un maximo de veces.");
    }

    public boolean usarExclusividad() throws JugadorNoTieneMasBonificadorError{
        if (usosExclusividad < MAX_USOS_EXCLUSIVIDAD) {
            this.usosExclusividad++;
            return true;
        }
        throw new JugadorNoTieneMasBonificadorError("El jugador ya ha usado la exclusividad un maximo de veces.");
    }

    public boolean usarAnulador() throws JugadorNoTieneMasBonificadorError{
        if (usosAnulador < MAX_USOS_ANULADOR) {
            this.usosAnulador++;
            return true;
        }
        throw new JugadorNoTieneMasBonificadorError("El jugador ya ha usado el anulador un maximo de veces.");
    }
}
