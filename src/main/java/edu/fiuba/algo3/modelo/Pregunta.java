package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.bonificador.AnuladorPuntajeDecorador;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;
import edu.fiuba.algo3.modelo.bonificador.MultiplicadorX2Decorador;

import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private TipoDePregunta tipo;
    private Penalidad penalidad;
    private ArrayList<Respuesta> respuestasJugadores;
    private Bonificador bonificador;

    public Pregunta(TipoDePregunta tipo, Penalidad penalidad, String enunciado, Bonificador bonificador){
        this.tipo = tipo;
        this.penalidad = penalidad;
        this.enunciado = enunciado;
        this.respuestasJugadores = new ArrayList<>();
        this.bonificador = bonificador;
    }

    public void agregarRespuesta(Respuesta respuestaJugador){
        respuestasJugadores.add(respuestaJugador);
    }

    private boolean verificarSiHayAlgunaIncorrecta(RespuestaCorregida respuestaCorregida){
        return respuestaCorregida.getRespuestasInorrectas() > 0;
    }
    private void validarRespuesta(Respuesta respuesta){
        RespuestaCorregida respuestaCorregida = tipo.corregirRespuesta(respuesta);
        verificarSiHayAlgunaIncorrecta(respuestaCorregida);
        respuestaCorregida.asignarPuntaje(penalidad, bonificador);
    }

    public void validarRespuestas(){
        for(Respuesta respuesta : respuestasJugadores){
            validarRespuesta(respuesta);
        }
    }
    public void aplicarMultiplicadorX2(Jugador jugador){
        if (!jugador.equals(this.respuestasJugadores.get(0).getJugador())){
            this.bonificador = new MultiplicadorX2Decorador(this.bonificador);
        }
    }
//    public void aplicarMultiplicadorX2(){
//        this.bonificador = new MultiplicadorX2Decorador(this.bonificador);
//    }
    public void aplicarAnulador(Jugador jugador){
        //Si el nombre del jugador que aplico el anulador es diferente al nombre del jugador de esta pregunta
        // Entonces se le aplica el anulador
        if (!jugador.equals(this.respuestasJugadores.get(0).getJugador())){
            //Agrego el bonificador de anular puntaje para
            this.bonificador = new AnuladorPuntajeDecorador(this.bonificador);
        }
    }
    public boolean ningunaIncorrecta(){
        boolean noHayIncorrecta = true;
        for(Respuesta respuesta : respuestasJugadores){
            RespuestaCorregida respuestaCorregida = tipo.corregirRespuesta(respuesta);
            if (noHayIncorrecta){
                noHayIncorrecta = verificarSiHayAlgunaIncorrecta(respuestaCorregida);
            }

        }
        return noHayIncorrecta;
    }

    public void agregarBonificador(Bonificador bonificador){
        this.bonificador = bonificador;
    }
}