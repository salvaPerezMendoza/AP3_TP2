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

    public void agregarBonificador(Jugador jugadorBonificado, Bonificador bonificador) {
        this.bonificador = BonificadorDecorador.crearDecorador(this.bonificador, bonificador,jugadorBonificado, this.respuestasJugador.get(0).getJugador());
    }

    public String getEnunciado(){
        return this.enunciado;
    }

    public String getTema() {
        return tema;
    }

    public TipoDePregunta getTipo() {
        return tipo;
    }

    public boolean respondieronTodos(int cantidadJugadores){
        return respuestasJugador.size() == cantidadJugadores;
    }
}