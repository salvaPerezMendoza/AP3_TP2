package edu.fiuba.algo3.modelo.bonificador;

public class AnuladorPuntajeDecorador extends BonificadorDecorador{
    public AnuladorPuntajeDecorador(Bonificador wrapped){
        super(wrapped);
    }
    public int modificarPuntaje(int puntaje){
        // Llamamos al metodo del decorador envuelto primero
        int nuevoPuntaje = super.modificarPuntaje(puntaje);

        // Multiplica el puntaje por dos y lo devuelve
        return nuevoPuntaje * 0;
    }
}
