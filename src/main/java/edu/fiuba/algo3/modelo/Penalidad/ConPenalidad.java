package edu.fiuba.algo3.modelo.Penalidad;

import edu.fiuba.algo3.modelo.Bonificadores.AnuladorDecorador;
import edu.fiuba.algo3.modelo.Bonificadores.BonificadorConcreto;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.RespuestaPuntuada;
import edu.fiuba.algo3.modelo.Bonificadores.BonificadorDecorador;
import edu.fiuba.algo3.modelo.Bonificadores.MultiplicadorDecorador;

import java.util.ArrayList;

import static java.util.stream.Collectors.toList;


public class ConPenalidad implements Penalidad {
    public ArrayList<BonificadorDecorador> obtenerBonificadoresDisponibles(Jugador jugador){
        ArrayList<BonificadorDecorador> multiplicadorx2 = jugador.getBonificadores().stream().filter(b -> b.getNombreBonificador().equals("Multiplicador x2")).collect(java.util.stream.Collectors.toCollection(ArrayList::new));
        ArrayList<BonificadorDecorador> multiplicadorx3 = jugador.getBonificadores().stream().filter(b -> b.getNombreBonificador().equals("Multiplicador x3")).collect(java.util.stream.Collectors.toCollection(ArrayList::new));
        ArrayList<BonificadorDecorador> anuladores = jugador.getBonificadores().stream().filter(b -> b.getNombreBonificador().equals("Anulador")).collect(java.util.stream.Collectors.toCollection(ArrayList::new));
        ArrayList<BonificadorDecorador> bonificadoresDisponibles = new ArrayList<>(multiplicadorx2);
        bonificadoresDisponibles.addAll(multiplicadorx3);
        bonificadoresDisponibles.addAll(anuladores);
        return bonificadoresDisponibles;
    }

    @Override
    public RespuestaPuntuada asignarPuntajeRespuesta(Jugador jugador, int cantidadCorrectas, int cantidadIncorrectas) {
        jugador.sumarPuntos(cantidadCorrectas);
        jugador.sumarPuntos(-cantidadIncorrectas);
        return new RespuestaPuntuada(jugador, cantidadCorrectas + cantidadIncorrectas);
    }
}
