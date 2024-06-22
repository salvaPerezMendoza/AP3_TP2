package edu.fiuba.algo3.excepciones;

public class JugadorNoTieneMasBonificadorError extends Exception {
    //extends Exception se usa para excepciones comprobadas que se pueden controlar
    public JugadorNoTieneMasBonificadorError() {
        super();
    }

    public JugadorNoTieneMasBonificadorError(String mensaje) {
        super(mensaje);
    }
}