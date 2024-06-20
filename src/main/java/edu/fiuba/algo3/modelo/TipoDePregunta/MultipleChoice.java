package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaCorregida;

import java.util.ArrayList;

public class MultipleChoice implements TipoDePregunta {
     ArrayList<Opcion> opcionesCorrectas;

     public MultipleChoice(ArrayList<Opcion> opciones){
         this.opcionesCorrectas = opciones;
     }

     public RespuestaCorregida corregirRespuesta(Respuesta respuesta){
          int cantidadCorrectas = 0;
          int cantidadIncorrectas = 0;
          ArrayList<Opcion> opcionesJugador = respuesta.getOpciones();
          for(int i = 0; i<opcionesJugador.size(); i++){
               Opcion opcionJugador = opcionesJugador.get(i);
               Opcion correcta = opcionesCorrectas.get(i);
               if(opcionJugador.esIgualA(correcta)){
                    cantidadCorrectas += 1;
               }
               else {
                    cantidadIncorrectas += 1;
               };
          }
          return new RespuestaCorregida(respuesta.getJugador(), cantidadCorrectas, cantidadIncorrectas);
     }

}
