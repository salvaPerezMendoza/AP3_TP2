package edu.fiuba.algo3.modelo.bonificador;


public class MultiplicadorX2Decorador extends BonificadorDecorador{
    public MultiplicadorX2Decorador(Bonificador wrapped){
        super(wrapped);
    }
    public int modificarPuntaje(int puntaje){
        // Llamamos al metodo del decorador envuelto primero
        int nuevoPuntaje = super.modificarPuntaje(puntaje);

        // Multiplica el puntaje por dos y lo devuelve
        return nuevoPuntaje * 2;

    }
}