package edu.fiuba.algo3.modelo.bonificador;

public class BonificadorDecorador implements Bonificador{
    private Bonificador wrapped;

    BonificadorDecorador(Bonificador wrapped){
        this.wrapped = wrapped;
    }
    public int modificarPuntaje(int puntaje){
        return wrapped.modificarPuntaje(puntaje);
    }
}