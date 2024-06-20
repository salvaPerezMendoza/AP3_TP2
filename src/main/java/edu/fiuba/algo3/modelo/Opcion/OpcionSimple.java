package edu.fiuba.algo3.modelo.Opcion;

public class OpcionSimple implements Opcion {
    String valor;
    public OpcionSimple(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean esIgualA(Opcion opcion) {
        OpcionSimple opcionSimple = (OpcionSimple) opcion;
        return this.valor.equals(opcionSimple.getValor());
    }
}
