package edu.fiuba.algo3.modelo.Opcion;

import java.util.HashSet;

public class OpcionGrupo implements Opcion {
    private HashSet<OpcionSimple> opciones;

    public OpcionGrupo(HashSet<OpcionSimple> valores){
        this.opciones = valores;
    }

    public void agregarValor(OpcionSimple valor){
        this.opciones.add(valor);
    }

    public HashSet<OpcionSimple> getValores() {
        return opciones;
    }

    @Override
    public boolean esIgualA(Opcion opcion) {
        OpcionGrupo opcionComparada = (OpcionGrupo) opcion;
        return this.opciones.equals(opcionComparada.getValores());
    }
}
