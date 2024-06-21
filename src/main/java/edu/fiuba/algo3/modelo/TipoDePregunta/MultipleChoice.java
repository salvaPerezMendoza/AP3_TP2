package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSimple;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.RespuestaCorregida;

import java.util.ArrayList;

public class MultipleChoice implements TipoDePregunta {
     ArrayList<Opcion> opciones;
     ArrayList<Opcion> opcionesCorrectas;

     public MultipleChoice(ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas){
          this.opciones = opciones;
          this.opcionesCorrectas = opcionesCorrectas;
     }

     private boolean contiene(OpcionSimple opcion){
          boolean contiene = false;
          int i = 0;
          while(!contiene && i < opcionesCorrectas.size()){
               if(opcionesCorrectas.get(i).esIgualA(opcion)){
                    contiene = true;
               }
               i += 1;
          }
          return contiene;
     }

     public RespuestaCorregida corregirRespuesta(Respuesta respuesta){
          int cantidadCorrectas = 0;
          int cantidadIncorrectas = 0;
          ArrayList<Opcion> opcionesJugador = respuesta.getOpciones();
          for(Opcion opcion : opcionesJugador){
               OpcionSimple opcionJugador = (OpcionSimple) opcion;
               if(contiene(opcionJugador)){
                    cantidadCorrectas += 1;
               }
          }
          cantidadIncorrectas = opcionesJugador.size() - cantidadCorrectas;
          return new RespuestaCorregida(respuesta.getJugador(), cantidadCorrectas, cantidadIncorrectas);
     }

}
