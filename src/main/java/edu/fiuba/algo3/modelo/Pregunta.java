package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.bonificadores.*;

import java.util.ArrayList;

public class Pregunta {
    private String enunciado;
    private TipoDePregunta tipo;
    private Penalidad penalidad;
    private ArrayList<Respuesta> respuestasJugador;
    private Bonificador bonificador;
    private String tema;


    public Pregunta(TipoDePregunta tipo, Penalidad penalidad, String enunciado,String tema){
        this.tipo = tipo;
        this.penalidad = penalidad;
        this.enunciado = enunciado;
        this.respuestasJugador = new ArrayList<>();
        this.bonificador = new BonificadorConcreto();
        this.tema = tema;
    }

    public void agregarRespuesta(Respuesta respuestaJugador){
        respuestasJugador.add(respuestaJugador);
    }

    private void validarRespuesta(Respuesta respuesta){
        RespuestaCorregida respuestaCorregida = tipo.corregirRespuesta(respuesta);
        verificarSiHayAlgunaIncorrecta(respuestaCorregida);
        respuestaCorregida.asignarPuntaje(penalidad, bonificador);
    }

    public void validarRespuestas(){
        for(Respuesta respuesta : respuestasJugador){
            validarRespuesta(respuesta);
        }
    }

    private boolean verificarSiHayAlgunaIncorrecta(RespuestaCorregida respuestaCorregida){
        return respuestaCorregida.getRespuestasInorrectas() > 0;
    }

    public boolean ningunaIncorrecta(){
        boolean noHayIncorrecta = true;
        for(Respuesta respuesta : respuestasJugador){
            RespuestaCorregida respuestaCorregida = tipo.corregirRespuesta(respuesta);
            if (noHayIncorrecta){
                noHayIncorrecta = verificarSiHayAlgunaIncorrecta(respuestaCorregida);
            }

        }
        return noHayIncorrecta;
    }

    public void agregarBonificador(Jugador jugador, String bonificador){
        //Si fue el jugador quien agrego el bonificador
        if (jugador.equals(this.respuestasJugador.get(0).getJugador())) {
            if (bonificador.equals("MultiplicadorX2")) {
                this.bonificador = new MultiplicadorX2Decorador(this.bonificador);
            }
        }
        //Si es diferente al jugador que agrego el bonificador
        if (!jugador.equals(this.respuestasJugador.get(0).getJugador())) {
            if (bonificador.equals("Anulador")) {
                this.bonificador = new AnuladorPuntajeDecorador(this.bonificador);
            }
        }
    }
    public String getEnunciado(){
        return this.enunciado;
    }

    public String getTema() {
        return tema;
    }
}