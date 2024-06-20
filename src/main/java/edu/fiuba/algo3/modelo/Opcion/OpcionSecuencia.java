package edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class OpcionSecuencia implements Opcion {
    ArrayList<String> valores;

    public ArrayList<String> getValores() {
        return valores;
    }

    public void agregarValor(String valor){
        valores.add(valor);
    }

    @Override
    public boolean esIgualA(Opcion opcion) {
        OpcionSecuencia opcionSecuencia = (OpcionSecuencia) opcion;
        return opcionSecuencia.getValores().equals(valores);
    }
}
