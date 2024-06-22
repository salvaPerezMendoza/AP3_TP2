package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.bonificador.Bonificador;

import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private TipoDePregunta tipo;
    private Penalidad penalidad;
    private ArrayList<Respuesta> respuestasJugadores;
    private Bonificador bonificador;
    private boolean ningunaIncorrecta;

    public Pregunta(TipoDePregunta tipo, Penalidad penalidad, String enunciado, Bonificador bonificador){
        this.tipo = tipo;
        this.penalidad = penalidad;
        this.enunciado = enunciado;
        this.respuestasJugadores = new ArrayList<>();
        this.bonificador = bonificador;
        this.ningunaIncorrecta = false;
    }

    public void agregarRespuesta(Respuesta respuestaJugador){
        respuestasJugadores.add(respuestaJugador);
    }
    private void verificarSiHayAlgunaIncorrecta(RespuestaCorregida respuestaCorregida){
        this.ningunaIncorrecta = respuestaCorregida.getRespuestasInorrectas() > 0;
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
    public boolean ningunaIncorrecta(){
        return this.ningunaIncorrecta;
    }
    public void agregarBonificador(Bonificador bonificador){
        this.bonificador = bonificador;
    }
}