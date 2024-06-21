package edu.fiuba.algo3.modelo.Opcion;

import java.util.HashSet;

public class OpcionGrupo implements Opcion {
    private String nombre;
    private HashSet<OpcionSimple> opciones;

    public OpcionGrupo(String nombre, HashSet<OpcionSimple> valores){
        this.nombre = nombre;
        this.opciones = valores;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarOpcion(OpcionSimple valor){
        this.opciones.add(valor);
    }

    public HashSet<OpcionSimple> getValores() {
        return opciones;
    }

    @Override
    public boolean esIgualA(Opcion opcionGrupo) {
        OpcionGrupo opcionComparada = (OpcionGrupo) opcionGrupo;
        HashSet<String> valoresComparada = new HashSet<>();
        HashSet<String> valoresGrupo = new HashSet<>();
        for(OpcionSimple opcion : opciones){
            valoresGrupo.add(opcion.getValor());
        }
        for(OpcionSimple opcion : opcionComparada.getValores()){
            valoresComparada.add(opcion.getValor());
        }
        return valoresComparada.equals(valoresGrupo);
    }
}
